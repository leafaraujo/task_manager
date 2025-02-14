package com.example.task_manager.repositories;

import com.example.task_manager.models.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class EmployeeRepository implements Serializable {
        private static final long serialVersionUID = 1L;

        private EntityManager manager;
        public EmployeeRepository() {}
        public EmployeeRepository(EntityManager manager) {
            this.manager = manager;
        }

        public Employee findById(Long id) {
            return manager.find(Employee.class, id);
        }

        public List<Employee> search(long id, String name) {
            TypedQuery<Employee> query = manager.createQuery("SELECT e FROM Employee e " + "JOIN e.department d " +
                    "WHERE d.id = :departmentId AND e.employeeName LIKE :employeeName", Employee.class);
            query.setParameter("departmentId", id);
            query.setParameter("employeeName", name + "%");
            return query.getResultList();
        }

        public Employee save(Employee employee) {
            return manager.merge(employee);
        }

        public void delete(Employee employee) {
            Employee employeeRemove  = manager.find(Employee.class, employee.getId());
            manager.remove(employeeRemove);
        }
}

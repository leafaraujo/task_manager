package com.example.task_manager.repositories;

import com.example.task_manager.models.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class DepartmentRepository implements Serializable {
    private static final long serialVersionUID = 1L;

    private EntityManager manager;
    public DepartmentRepository() {}
    public DepartmentRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Department findById(Long id) {
        return manager.find(Department.class, id);
    }

    public List<Department> search(String name) {
        TypedQuery <Department> query = manager.createQuery("FROM Department d WHERE d.departmentName LIKE :departmentName", Department.class);
        query.setParameter("departmentName", name + "%");
        return query.getResultList();
    }

    public Department save(Department department) {
        return manager.merge(department);
    }

    public void delete(Department department) {
        Department deparmentRemove  = manager.find(Department.class, department.getId());
        manager.remove(deparmentRemove);
    }

}

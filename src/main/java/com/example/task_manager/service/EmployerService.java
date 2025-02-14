package com.example.task_manager.service;

import com.example.task_manager.models.Employee;
import com.example.task_manager.repositories.EmployeeRepository;
import com.example.task_manager.util.Transacional;

import jakarta.inject.Inject;
import java.io.Serializable;

public class EmployerService implements Serializable {

    @Inject
    private EmployeeRepository employeeRepository;

    @Transacional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transacional
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}

package com.example.task_manager.service;

import com.example.task_manager.models.Department;
import com.example.task_manager.repositories.DepartmentRepository;
import com.example.task_manager.util.Transacional;

import jakarta.inject.Inject;
import java.io.Serializable;

public class DepartmentService implements Serializable {

    @Inject
    private DepartmentRepository departmentRepository;

    @Transacional
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Transacional
    public void delete(Department department) {
        departmentRepository.delete(department);
    }
}

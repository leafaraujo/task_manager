package com.example.task_manager.service;

import com.example.task_manager.models.Task;
import com.example.task_manager.repositories.TaskRepository;
import com.example.task_manager.util.Transacional;

import jakarta.inject.Inject;
import java.io.Serializable;

public class TaskService implements Serializable {
    @Inject
    private TaskRepository taskRepository;

    @Transacional
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Transacional
    public void delete(Task task) {
        taskRepository.delete(task);
    }
}

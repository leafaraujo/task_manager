package com.example.task_manager.repositories;
import com.example.task_manager.models.Task;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class TaskRepository implements Serializable {
    private static final long serialVersionUID = 1L;
    private EntityManager manager;
    public TaskRepository() {}
    public TaskRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Task findById(Long id) {
        return manager.find(Task.class, id);
    }

    public List<Task> searchByDepartment(long id, String name) {
        TypedQuery<Task> query = manager.createQuery("SELECT t FROM Task t " + "JOIN t.department d " +
                "WHERE d.id = :departmentId AND t.title LIKE :title", Task.class);
        query.setParameter("departmentId", id);
        query.setParameter("title", name + "%");
        return query.getResultList();
    }

    public List<Task> searchByEmployee(long id, String name) {
        TypedQuery<Task> query = manager.createQuery("SELECT t FROM Task t " + "JOIN t.employee e " +
                "WHERE e.id = :employeeId AND t.title LIKE :title", Task.class);
        query.setParameter("employeeId", id);
        query.setParameter("title", name + "%");
        return query.getResultList();
    }


    public Task save(Task task) {
        return manager.merge(task);
    }

    public void delete(Task task) {
        Task categoryRemove  = manager.find(Task.class, task.getId());
        manager.remove(categoryRemove);
    }
}

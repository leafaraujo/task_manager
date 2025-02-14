package com.example.task_manager.repositories;

import com.example.task_manager.models.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class CategoryRepository implements Serializable {
    private static final long serialVersionUID = 1L;

    private EntityManager manager;
    public CategoryRepository() {}
    public CategoryRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Category findById(Long id) {
        return manager.find(Category.class, id);
    }

    public List<Category> search(long id, String name) {
        TypedQuery<Category> query = manager.createQuery("SELECT c FROM Category c " + "JOIN c.department d " +
                "WHERE d.id = :departmentId AND c.categoryName LIKE :categoryName", Category.class);
        query.setParameter("departmentId", id);
        query.setParameter("categoryName", name + "%");
        return query.getResultList();
    }

    public Category save(Category category) {
        return manager.merge(category);
    }

    public void delete(Category category) {
        Category categoryRemove  = manager.find(Category.class, category.getId());
        manager.remove(categoryRemove);
    }
}

package com.example.task_manager.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import com.example.task_manager.models.Employee;

@Entity
@Table(name = "department")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int priority;

    @Column(nullable = false, name = "name")
    private String departmentName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    @OneToMany
    @JoinColumn(name = "employee_ids")
    private ArrayList <Employee> employee;

    @OneToMany
    @JoinColumn(name = "category_ids")
    private ArrayList <Category> category;

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getSectorName() {
        return departmentName;
    }

    public void setSectorName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department sector = (Department) o;
        return Objects.equals(id, sector.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Sector{" +
                "id=" + id +
                '}';
    }
}

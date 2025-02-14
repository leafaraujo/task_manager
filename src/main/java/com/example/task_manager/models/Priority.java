package com.example.task_manager.models;

public enum Priority {
    LOWER("Baixa"),
    MEDIUM("Média"),
    HIGHER("Alta");

    private final String type;

    private Priority(String priority){
        this.type = priority;
    }

    public String getPriority(){
        return this.type;
    }
}

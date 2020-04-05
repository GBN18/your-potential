package com.example.gavrielsappv1.entity;

import java.util.Random;

public class Task
{
    private Long id;
    private String name;
    private String description;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = new Random().nextLong();
    }

    public long getID() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

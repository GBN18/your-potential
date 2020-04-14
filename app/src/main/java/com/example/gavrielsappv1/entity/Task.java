package com.example.gavrielsappv1.entity;
import java.util.Random;

public class Task {
    private Long id;
    private String name;
    private String description;
    private String date;
    private Integer mod;

    public Task(String name, String description, String date, Integer mod) {
        this.name = name;
        this.description = description;
        this.id = new Random().nextLong();
        this.date = date;
        this.mod = mod;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getMod() {
        return mod;
    }

    public void setMod(Integer mod) {
        this.mod = mod;
    }
}

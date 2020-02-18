package com.example.gavrielsappv1.entity;

public class Task
{
    private String name;
    private String description;

    public Task(String name,String description){
        this.setName(name);
        this.setDescription(description);
    }
    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
}

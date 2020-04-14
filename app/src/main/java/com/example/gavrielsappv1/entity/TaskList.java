package com.example.gavrielsappv1.entity;

import java.util.ArrayList;

public class TaskList {
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public int size() {
        return this.tasks.size();
    }

    public Task get(int position) {
        return this.tasks.get(position);
    }

    public void add(String name,String description,String date,int mod) {
        this.tasks.add(new Task(name,description,date,mod));
    }
}

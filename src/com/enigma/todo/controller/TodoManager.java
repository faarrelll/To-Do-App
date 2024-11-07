package com.enigma.todo.controller;

import com.enigma.todo.exception.ValidatorException;
import com.enigma.todo.model.Todo;
import com.enigma.todo.utils.ScannerUtils;

import java.util.ArrayList;
import java.util.List;

public class TodoManager {
    private List<Todo> taskList = new ArrayList<>();

    public void addTask() {
        Todo newTask = new Todo();
        try {
            newTask.setTitle(ScannerUtils.scanText("Tittle"));
            newTask.setDescription(ScannerUtils.scanText("Description"));
            taskList.add(newTask);
            System.out.println("Add Task Success");
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTask() {
        viewTask();
        String id = ScannerUtils.scanText("Enter Task ID to delete");
        boolean isRemoved = taskList.remove(getById(id));
        if (isRemoved) {
            System.out.println("Delete Task Success");
        } else {
            System.out.println("Delete Task Failed");
        }
    }

    public void updateTask() {
        viewTask();
        String id = ScannerUtils.scanText("Enter Task ID to update");
        Todo update = getById(id);
        if (update != null) {
            update.setCompleted(ScannerUtils.scanBollean("isComplete (true/false)"));
            System.out.println("Succes Update Data");
        } else{
            System.out.println("ID not found!");
        }
    }

    public void viewTask() {
        if (taskList.isEmpty()) {
            System.out.println("Task is empty");
        } else {
            taskList.forEach(Todo::getInfo);
        }
    }

    public Todo getById(String id){
        for(Todo todo : taskList ){
            if (todo.getUuid().equals(id)){
                return todo;
            }
        }
        return null;
    }
}

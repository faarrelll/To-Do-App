package com.enigma.todo.model;

import com.enigma.todo.exception.ValidatorException;

import java.time.LocalDate;
import java.util.UUID;

public class Todo {
    private String uuid;
    private String title;
    private String description;
    private boolean completed;
    private LocalDate date;

    public Todo() {
        UUID key = UUID.randomUUID();
        setUuid(key.toString());
        setDate(LocalDate.now());
        setCompleted(false);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }

    public void getInfo() {
        System.out.println("ID : " + uuid);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Date: " + date);
        if (completed) {
            System.out.println("Status : completed ");
        } else {
            System.out.println("Status : not completed");
        }

    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setTitle(String title) throws ValidatorException {
        if (title == null || title.isEmpty() || title.isBlank()) {
            throw new ValidatorException("Title cannot be empty bro!");
        }
        this.title = title;
    }


    public void setDescription(String description) throws ValidatorException {
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new ValidatorException("description cannot be null bro!");
        }
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

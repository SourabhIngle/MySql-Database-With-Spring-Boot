package com.bridgelabz.mysqldatabase.model;
//model layer for the entity.

import com.bridgelabz.mysqldatabase.dto.MyDatabaseDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

//with the help of @Entity it will create a table in database.
// Database name is = SqlDemo
@Entity
@Table(name = "Database_Table")
public class MyDatabase {

    @Id              // This annotation is showing this is my primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // AUTO IDENTITY TABLE
    private Long Id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Boolean completed;

    public MyDatabase() {
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    public MyDatabase(MyDatabaseDTO myDatabaseDTO) {
        this.updateMessage(myDatabaseDTO);
    }

    public void updateMessage(MyDatabaseDTO myDatabaseDTO) {
        this.title = myDatabaseDTO.title;
        this.description = myDatabaseDTO.description;
        this.dueDate = myDatabaseDTO.dueDate;
        this.completed = myDatabaseDTO.completed;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


}

package com.example.taskmanager_spring.entities;

import lombok.Data;

import java.util.Date;

@Data
public class TaskEntity {
    private Date deadline;
    private int id;
    private String title;
    private String description;
    private Boolean completed;


}

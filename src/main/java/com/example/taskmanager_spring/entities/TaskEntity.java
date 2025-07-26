package com.example.taskmanager_spring.entities;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TaskEntity {
    private Date deadline;
    private int id;
    private String title;
    private String description;
    private Boolean completed;
    private List<NoteEntity> notes;


}

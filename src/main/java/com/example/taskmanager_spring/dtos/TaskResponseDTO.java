package com.example.taskmanager_spring.dtos;

import com.example.taskmanager_spring.entities.NoteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Setter
@NoArgsConstructor
@Getter
public class TaskResponseDTO {
    private Date deadline;
    private int id;
    private String title;
    private String description;
    private Boolean completed;
    private List<NoteEntity> notes;

}

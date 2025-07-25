package com.example.taskmanager_spring.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CreateNoteDTO {
    private String title;
    private String body;
}

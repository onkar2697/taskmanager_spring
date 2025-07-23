package com.example.taskmanager_spring.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpadteTaskDTO {
    String description;
    String deadline;
    Boolean completed;
}

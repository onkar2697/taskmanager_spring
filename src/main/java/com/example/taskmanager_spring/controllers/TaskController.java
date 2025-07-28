package com.example.taskmanager_spring.controllers;

import com.example.taskmanager_spring.dtos.CreateTaskDTO;
import com.example.taskmanager_spring.dtos.ErrorResponseDTO;
import com.example.taskmanager_spring.dtos.TaskResponseDTO;
import com.example.taskmanager_spring.dtos.UpadteTaskDTO;
import com.example.taskmanager_spring.entities.TaskEntity;
import com.example.taskmanager_spring.service.NoteService;
import com.example.taskmanager_spring.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final NoteService noteService;
    private ModelMapper modelMapper = new ModelMapper();

    public TaskController(TaskService taskService, NoteService noteService){
        this.taskService= taskService;
        this.noteService = noteService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){
        var tasks = taskService.getTasks();

        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable("id")  Integer id){
         var tasks = taskService.getTaskById(id);
         var notes = noteService.getNotesForTask(id);
         if(tasks == null){
             return ResponseEntity.notFound().build();
         }
         var taskResponse = modelMapper.map(tasks,TaskResponseDTO.class);
         taskResponse.setNotes(notes);
         return ResponseEntity.ok(taskResponse);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) throws ParseException {
        var task = taskService.addTask(body.getTitle(),body.getDescription(), body.getDeadline());


        return ResponseEntity.ok(task);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception e){
        if(e instanceof ParseException){
            return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalide dateformat"));
        }
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Invalid request"));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable("id") Integer id, @RequestBody UpadteTaskDTO body) throws ParseException{
        var task= taskService.UpdateTask(id,body.getDescription(), body.getDeadline(), body.getCompleted());

        if(task == null){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(task);
    }
}

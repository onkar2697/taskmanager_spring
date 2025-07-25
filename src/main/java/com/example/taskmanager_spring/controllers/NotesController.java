package com.example.taskmanager_spring.controllers;

import com.example.taskmanager_spring.dtos.CreateNoteDTO;
import com.example.taskmanager_spring.dtos.CreateNoteResponseDTO;
import com.example.taskmanager_spring.entities.NoteEntity;
import com.example.taskmanager_spring.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{id}/notes")
public class NotesController {

    private NoteService noteService;

    public NotesController(NoteService noteService){
        this.noteService = noteService;
    }

    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId")Integer taskId){
        var notes = noteService.getNotesForTask(taskId);

        return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<CreateNoteResponseDTO> addNote(
            @PathVariable("id") Integer taskId,
            @RequestBody CreateNoteDTO body){

        var note = noteService.addNoteForTask(taskId, body.getTitle(), body.getBody());
        return ResponseEntity.ok(new CreateNoteResponseDTO(taskId,note));

    }
}

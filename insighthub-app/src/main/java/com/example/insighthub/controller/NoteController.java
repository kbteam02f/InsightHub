package com.example.insighthub.controller;

import com.example.rendering.model.Note;
import com.example.rendering.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("notes")
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public List<Note> getNotes() {
        return noteService.getAllNotes();
    }


    @GetMapping("/{id}")
    public Note getNote(@PathVariable String id) {
        return noteService.getNoteById(id);
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable String id) {
        return noteService.deleteNote(id)
                ? ResponseEntity.ok(null)
                : ResponseEntity.notFound().build();
    }


}

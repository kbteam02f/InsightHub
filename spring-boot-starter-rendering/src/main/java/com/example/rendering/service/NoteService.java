package com.example.rendering.service;

import com.example.rendering.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(String id);
    Note saveNote(Note note);
    boolean deleteNote(String id);
}

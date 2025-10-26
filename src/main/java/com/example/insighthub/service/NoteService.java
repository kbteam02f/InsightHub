package com.example.insighthub.service;

import com.example.insighthub.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(String id);
    Note saveNote(Note note);
    boolean deleteNote(String id);
}

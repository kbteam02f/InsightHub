package com.example.insighthub.service.impl;

import com.example.insighthub.model.Note;
import com.example.insighthub.service.NoteService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class NoteServiceImpl implements NoteService {

    private final Map<String, Note> noteMap = new HashMap<>();

    @Override
    public List<Note> getAllNotes() {
        return new ArrayList<>(noteMap.values());
    }

    @Override
    public Note getNoteById(String id) {
        return noteMap.get(id);
    }

    @Override
    public Note saveNote(Note note) {
        note.setId(UUID.randomUUID().toString());
        note.setCreatedAt(LocalDateTime.now().toString());
        noteMap.put(note.getId(), note);
        return note;
    }

    @Override
    public boolean deleteNote(String id) {
        return noteMap.remove(id) != null;
    }
}

package com.example.insighthub.service.impl;

import com.example.insighthub.markdown.spring.events.NoteCreatedEvent;
import com.example.insighthub.model.Note;
import com.example.insighthub.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService, InitializingBean, DisposableBean {

    private final ApplicationEventPublisher eventPublisher;

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
        eventPublisher.publishEvent(new NoteCreatedEvent(this, note));
        return note;
    }

    @Override
    public boolean deleteNote(String id) {
        return noteMap.remove(id) != null;
    }

    @Override
    public void destroy() {
        System.out.println("NoteService: destroying...");
        noteMap.clear();
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("NoteService: initializing...");
        generateNotes().forEach(note -> noteMap.put(note.getId(), note));
        System.out.println("NoteService: generated " + noteMap.size() + " notes");
    }

    private List<Note> generateNotes() {
        int notesNumber = new Random().nextInt(0, 6);
        return IntStream.range(0, notesNumber).mapToObj(i ->
                        new Note(UUID.randomUUID().toString(),
                                "title %s".formatted(i),
                                "content %s".formatted(i),
                                "author %s".formatted(i),
                                LocalDateTime.now().minusDays(i).toString()))
                .toList();
    }
}

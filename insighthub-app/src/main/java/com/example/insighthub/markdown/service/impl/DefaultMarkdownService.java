package com.example.insighthub.markdown.service.impl;

import com.example.insighthub.markdown.service.MarkdownService;
import com.example.insighthub.model.Note;
import com.example.insighthub.service.NoteService;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class DefaultMarkdownService implements MarkdownService {
    private final NoteService noteService;
    @Override
    public String render(String id) {
        Note note = noteService.getNoteById(id);
        if (Objects.isNull(note)) {
            return null;
        }
        return note.getTitle().concat(" ").concat(note.getContent()).concat(" ").concat(note.getAuthor());
    }
}

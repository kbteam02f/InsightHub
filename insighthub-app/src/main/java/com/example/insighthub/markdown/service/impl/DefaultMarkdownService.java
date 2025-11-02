package com.example.insighthub.markdown.service.impl;

import com.example.insighthub.markdown.service.MarkdownService;
import com.example.rendering.model.Note;
import com.example.rendering.service.NoteService;
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
        return note.getTitle().concat("\n").concat(note.getContent()).concat("\n").concat(note.getAuthor());
    }
}

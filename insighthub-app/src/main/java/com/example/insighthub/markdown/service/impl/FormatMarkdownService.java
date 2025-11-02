package com.example.insighthub.markdown.service.impl;

import com.example.rendering.model.Note;
import com.example.rendering.NoteRenderingProperties;
import com.example.insighthub.markdown.service.MarkdownService;
import com.example.rendering.service.NoteService;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class FormatMarkdownService implements MarkdownService {
    private final NoteService noteService;
    private final NoteRenderingProperties props;

    @Override
    public String render(String id) {
        Note note = noteService.getNoteById(id);
        if (Objects.isNull(note)) {
            return null;
        }
        if (!props.getEnabled()) {
            return note.getTitle().concat(note.getContent()).concat(note.getAuthor());
        }
        if (note.getContent().length() > props.getMaxLength()) {
            note.setContent(note.getContent().substring(0, props.getMaxLength() - 3).concat("..."));
        }
        return "<h1>%s</h1>\n<p>%s</p>\n<h3>%s</h3>\n".formatted(note.getTitle(), note.getContent(), note.getAuthor());
    }
}

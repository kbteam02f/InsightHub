package com.example.insighthub.markdown.service;

import com.example.insighthub.model.Note;

public class DefaultMarkdownService implements MarkdownService {
    @Override
    public String render(Note markdown) {
        return markdown.getTitle().concat(" ").concat(markdown.getContent()).concat(" ").concat(markdown.getAuthor());
    }
}

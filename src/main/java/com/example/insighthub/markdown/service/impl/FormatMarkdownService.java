package com.example.insighthub.markdown.service.impl;

import com.example.insighthub.markdown.service.MarkdownService;
import com.example.insighthub.model.Note;

public class FormatMarkdownService implements MarkdownService {
    @Override
    public String render(Note markdown) {
        return "<h1>%s</h1>\n<p>%s</p>\n<h3>%s</h3>".formatted(markdown.getTitle(), markdown.getContent(), markdown.getAuthor());
    }
}

package com.example.insighthub.markdown.service;

import com.example.insighthub.model.Note;

public interface MarkdownService {
    String render(Note markdown);
}

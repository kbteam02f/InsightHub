package com.example.insighthub.controller;

import com.example.insighthub.markdown.service.MarkdownService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("markdown")
@RequiredArgsConstructor
public class MarkdownController {

    private final MarkdownService markdownService;

    @GetMapping("/render/{id}")
    public String renderMarkdown(@PathVariable String id) {
        return markdownService.render(id);
    }
}

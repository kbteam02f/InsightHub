package com.example.insighthub.markdown;

import com.example.insighthub.config.NoteRenderingProperties;
import com.example.insighthub.markdown.service.MarkdownService;
import com.example.insighthub.markdown.service.impl.DefaultMarkdownService;
import com.example.insighthub.markdown.service.impl.FormatMarkdownService;
import com.example.insighthub.service.NoteService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarkdownAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "insighthub.markdown", name = "enabled", havingValue = "true")
    public MarkdownService formatMarkdownService(NoteService noteService, NoteRenderingProperties noteRenderingProperties) {
        return new FormatMarkdownService(noteService, noteRenderingProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public MarkdownService defaultMarkdownService(NoteService noteService) {
        return new DefaultMarkdownService(noteService);
    }

}

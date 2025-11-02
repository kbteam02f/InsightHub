package com.example.rendering;

import com.example.rendering.service.NoteService;
import com.example.rendering.service.impl.NoteServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(NoteRenderingProperties.class)
public class RenderingAutoConfiguration {
    @Bean
    public NoteService noteService(ApplicationEventPublisher eventPublisher) {
        return new NoteServiceImpl(eventPublisher);
    }
}

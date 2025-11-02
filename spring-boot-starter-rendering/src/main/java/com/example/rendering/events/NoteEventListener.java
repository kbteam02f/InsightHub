package com.example.rendering.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NoteEventListener {

    @EventListener
    public void handleNoteCreatedEvent(NoteCreatedEvent event) {
        System.out.printf("Event: note created with id [%s]", event.getNote().getId());
    }
}

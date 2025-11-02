package com.example.rendering.events;

import com.example.rendering.model.Note;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class NoteCreatedEvent extends ApplicationEvent {
    private final Note note;

    public NoteCreatedEvent(Object source, Note note) {
        super(source);
        this.note = note;
    }

}

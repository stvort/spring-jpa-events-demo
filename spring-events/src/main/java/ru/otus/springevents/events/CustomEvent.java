package ru.otus.springevents.events;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

    private final String message;

    public CustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    @Override
    public String toString() {
        return "CustomEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}

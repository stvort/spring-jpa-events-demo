package ru.otus.springevents.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener2 {
    @EventListener
    public void onApplicationEvent(CustomEvent event) {
        System.out.printf("CustomEventListener2 поймал событие: %s%n", event);
    }
}

package ru.otus.jpaevents.events;

import lombok.Data;
import ru.otus.jpaevents.model.Developer;

@Data
public class HrEvent {
    private final String eventName;
    private final Developer developer;

    public HrEvent(String eventName, Developer developer) {
        this.eventName = eventName;
        this.developer = developer;
        //this.developer = new Developer(developer.getId(), developer.getLevel(), developer.getFullName());
    }
}

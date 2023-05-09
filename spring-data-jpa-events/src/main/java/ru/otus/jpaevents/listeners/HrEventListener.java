package ru.otus.jpaevents.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.otus.jpaevents.events.HrEvent;

@Slf4j
@Component
public class HrEventListener {

    @EventListener
    public void onHrEvent(HrEvent event) {
        System.out.printf("Произошло HR событие: %s%n", event);
        processEvent(event);
    }

    private void processEvent(HrEvent event) {
        //SleepUtil.sleep(3);
        //event.getDeveloper().setLevel(100500);
        throw new RuntimeException("Ooops");
    }
}

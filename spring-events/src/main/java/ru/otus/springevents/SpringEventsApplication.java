package ru.otus.springevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.springevents.events.CustomEventPublisher;

@SpringBootApplication
public class SpringEventsApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringEventsApplication.class, args);
		CustomEventPublisher customEventPublisher = ctx.getBean(CustomEventPublisher.class);
		customEventPublisher.publishCustomEvent("Тыдыщ!");
		//ctx.publishEvent(new CustomEvent(ctx, "Тыдыщ!"));
	}

}

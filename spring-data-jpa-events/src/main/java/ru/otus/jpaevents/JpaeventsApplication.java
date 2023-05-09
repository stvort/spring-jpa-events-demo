package ru.otus.jpaevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.jpaevents.model.Developer;
import ru.otus.jpaevents.services.DeveloperService;

@SpringBootApplication
public class JpaeventsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(JpaeventsApplication.class, args);
        doWorkWithDeveloper(ctx);
    }

    private static void doWorkWithDeveloper(ApplicationContext ctx) {
        var developerService = ctx.getBean(DeveloperService.class);

        var newDeveloper = developerService.save(new Developer(0L, 13, "Вася"));
        System.out.printf("Сохраненный разработчик: %s%n%n", newDeveloper);

        try {
            newDeveloper = developerService.levelUpById(newDeveloper.getId());
            System.out.printf("Разработчик после повышения уровня: %s%n%n", newDeveloper);
        } catch (Exception e) {
            System.out.printf("Ошибка при повышении уровня: %s%n%n", e.getMessage());
            var actualDeveloper = developerService.findById(newDeveloper.getId());
            System.out.printf("Разработчик, которому не удалось сменить уровень: %s%n%n", actualDeveloper);
        }

        newDeveloper = developerService.updateNameById(newDeveloper.getId(), "Василий Петрович");
        System.out.printf("Повзрослевший разработчик: %s%n%n", newDeveloper);
    }


}

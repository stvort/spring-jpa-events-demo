package ru.otus.jpaevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.jpaevents.model.User;
import ru.otus.jpaevents.services.UserService;

@SpringBootApplication
public class JpaeventsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(JpaeventsApplication.class, args);
		doWorkWithUser(ctx);
	}

	private static void doWorkWithUser(ApplicationContext ctx){
		var userService = ctx.getBean(UserService.class);

		System.out.println("Сохранение...");
		var newUser = userService.save(new User(0L, "vasya"));
		System.out.printf("Сохраненный пользователь: %s%n%n", newUser);

		newUser = userService.findById(newUser.getId());
		System.out.printf("Загруженный пользователь: %s%n%n", newUser);


		System.out.println("Обновление...");
		var newUserLogin = newUser.getLogin().replace("vasya", "Vasiliy");
		newUser = userService.updateLoginById(newUser.getId(), newUserLogin);
		System.out.printf("Пользователь после смены логина: %s%n%n", newUser);

		newUser = userService.findById(newUser.getId());
		System.out.printf("Загруженный пользователь: %s%n%n", newUser);

		System.out.println("Удаление...");
		userService.deleteUserById(newUser.getId());
	}

}
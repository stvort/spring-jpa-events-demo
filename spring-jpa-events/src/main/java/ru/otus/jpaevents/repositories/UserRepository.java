package ru.otus.jpaevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.jpaevents.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

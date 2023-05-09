package ru.otus.jpaevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.jpaevents.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}

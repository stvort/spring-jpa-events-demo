package ru.otus.jpaevents.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.jpaevents.listeners.EntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@EntityListeners(EntityListener.class)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String login;

    private LocalDateTime creationTime;
    private LocalDateTime lastUpdateTime;

    @Transient
    private long eventsOccursCount = 0;

    public User(long id, String login) {
        this.id = id;
        this.login = login;
    }

    public void eventsOccurs() {
        eventsOccursCount++;
    }

/*    @PrePersist
    @PreUpdate
    private void beforeSave() {
        lastUpdateTime = LocalDateTime.now();
        eventsOccurs();
        System.out.printf("Произошло событие жизненного цикла beforeSave, сущность: %s%n", this);
    }*/


}

package ru.otus.jpaevents.listeners;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import ru.otus.jpaevents.model.User;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;
import static ru.otus.jpaevents.heplers.SleepUtil.sleep;

public class EntityListener {

    @PrePersist
    @PreUpdate
    private void beforeSave(User entity) {
        audit(entity);
        logEvent("beforeSave", entity);
        //sleep(5);
        //entity.setLogin(entity.getLogin() + " beforeSave");
    }

    @PostPersist
    @PostUpdate
    private void afterSave(User entity) {
        logEvent("afterSave", entity);
        //entity.setLogin(entity.getLogin() + " afterSave");
    }

    @PreRemove
    private void beforeRemove(User entity) {
        logEvent("beforeRemove", entity);
    }

    @PostRemove
    private void afterRemove(User entity) {
        logEvent("afterRemove", entity);
    }

    @PostLoad
    private void afterLoad(User entity) {
        logEvent("loading", entity);
        //entity.setLogin(entity.getLogin() + " loading");
    }

    private void logEvent(String description, User entity) {
        entity.eventsOccurs();
        System.out.printf("Произошло событие жизненного цикла %s, сущность: %s%n", description, entity);
    }

    private static void audit(User entity) {
        if (isNull(entity.getCreationTime())) {
            entity.setCreationTime(LocalDateTime.now());
        }
        entity.setLastUpdateTime(LocalDateTime.now());
    }

}

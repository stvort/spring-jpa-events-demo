package ru.otus.jpaevents.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import ru.otus.jpaevents.events.HrEvent;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "developers")
public class Developer {// extends AbstractAggregateRoot<Developer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "level")
    private int level;

    @Column(name = "full_name")
    private String fullName;

    @Transient
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private final List<Object> domainEvents = new ArrayList<>();

    public void levelUp() {
        level++;
        domainEvents.add(new HrEvent("Повышение уровня", this));
        //registerEvent(new HrEvent("Повышение уровня", this));
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        domainEvents.add(new HrEvent("Смена имени", this));
        //registerEvent(new HrEvent("Смена имени", this));
    }

    @DomainEvents
    public List<Object> domainEvents() {
        return domainEvents;
    }

    @AfterDomainEventPublication
    public void clearDomainEvents() {
        domainEvents.clear();
    }
}

package ru.otus.jpaevents.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.jpaevents.heplers.SleepUtil;
import ru.otus.jpaevents.model.Developer;
import ru.otus.jpaevents.repositories.DeveloperRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DeveloperService {
    private final DeveloperRepository developerRepository;

    public List<Developer> findAll() {
        return developerRepository.findAll();
    }

    public Developer findById(long id) {
        return developerRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    @Transactional
    // See: EventPublishingRepositoryProxyPostProcessor
    // See: AbstractPlatformTransactionManager#processCommit
    public Developer levelUpById(long id) {
        var developer = findById(id);
        developer.levelUp();
        developer = developerRepository.save(developer);
        SleepUtil.sleep(0);
        return developer;
    }

    @Transactional
    public Developer updateNameById(long id, String fullName) {
        var developer = findById(id);
        developer.setFullName(fullName);
        return developer;
    }

}

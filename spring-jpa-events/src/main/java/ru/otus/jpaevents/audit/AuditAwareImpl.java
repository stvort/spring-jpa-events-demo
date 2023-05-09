package ru.otus.jpaevents.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // Тут можно достать текущего юзера из SecurityContextHolder-а
        return Optional.of("Главный Аудитор");
    }
}

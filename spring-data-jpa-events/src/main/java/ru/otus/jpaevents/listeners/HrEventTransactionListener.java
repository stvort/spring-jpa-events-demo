package ru.otus.jpaevents.listeners;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.otus.jpaevents.events.HrEvent;

import java.util.Map;

import static org.springframework.transaction.event.TransactionPhase.AFTER_COMMIT;
import static org.springframework.transaction.event.TransactionPhase.AFTER_COMPLETION;
import static org.springframework.transaction.event.TransactionPhase.AFTER_ROLLBACK;
import static org.springframework.transaction.event.TransactionPhase.BEFORE_COMMIT;

@Component
public class HrEventTransactionListener {

    @TransactionalEventListener(phase = BEFORE_COMMIT)
    public void onHrEventBeforeTransactionCommit(HrEvent event) {
        logEvent(BEFORE_COMMIT, event);
        // Изменить штатное расписание.
        // Повысить зарплату.
        // Назначить доступы.
    }

    @TransactionalEventListener(phase = AFTER_COMMIT)
    public void onHrEventAfterTransactionCommit(HrEvent event) {
        logEvent(AFTER_COMMIT, event);
        // Уведомить по почте, что повышение завершено.
        // Интеграция с другими системами.
    }

    @TransactionalEventListener(phase = AFTER_ROLLBACK)
    public void onHrEventAfterTransactionRollback(HrEvent event) {
        logEvent(AFTER_ROLLBACK, event);
        // Уведомить администратора.
        // Логгировать неудачную попытку повышения.
        // Послать сообщение на новый круг обработки.
    }

    @TransactionalEventListener(phase = AFTER_COMPLETION)
    public void onHrEventAfterTransactionCompletion(HrEvent event) {
        logEvent(AFTER_COMPLETION, event);
        // Логгирование завершения обработки события.
    }

    private void logEvent(TransactionPhase phase, HrEvent event) {
        var phaseMessages = Map.of(BEFORE_COMMIT, "транзакция пока не зафиксирована",
                AFTER_COMMIT, "транзакция уже зафиксирована",
                AFTER_ROLLBACK, "но был откат транзакции",
                AFTER_COMPLETION, "транзакция уже зафиксирована или был ее откат");
        var phaseDescription = phaseMessages.get(phase);
        System.out.printf("Произошло HR событие (%s): %s%n", phaseDescription, event);
    }
}

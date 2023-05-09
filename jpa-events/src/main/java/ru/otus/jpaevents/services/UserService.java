package ru.otus.jpaevents.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.jpaevents.model.User;
import ru.otus.jpaevents.repositories.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    //@Transactional
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User updateLoginById(long id, String login) {
        var user = findById(id);
        user.setLogin(login);
        user = userRepository.save(user);
        return user;
    }

    @Transactional
    public void deleteUserById(long id) {
        var user = findById(id);
        userRepository.delete(user);
    }

}

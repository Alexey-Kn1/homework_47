package ru.netology.service;

import org.springframework.stereotype.Component;
import ru.netology.model.Authorities;
import ru.netology.model.InvalidCredentials;
import ru.netology.model.UnauthorizedUser;
import ru.netology.repository.UserRepository;

import java.util.List;

@Component
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository repository) {
        userRepository = repository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}

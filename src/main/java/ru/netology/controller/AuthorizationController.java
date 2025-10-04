package ru.netology.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.model.Authorities;
import ru.netology.service.AuthorizationService;
import ru.netology.model.UserAuthentificationData;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid UserAuthentificationData request) {
        return service.getAuthorities(request.getUser(), request.getPassword());
    }
}

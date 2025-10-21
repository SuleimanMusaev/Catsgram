package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Collection<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{userId}")
    public Optional<User> findUserById(@PathVariable long userId) {
        return userService.findUserById(userId);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);

        return ResponseEntity
                .status(HttpStatus.CREATED) // указываем код статуса
                .body(createdUser); // указываем тело ответа — эта операция завершает создание ResponseEntity
    }

    @PutMapping
    public User update(@RequestBody User newUser) {
        return userService.update(newUser);
    }
}

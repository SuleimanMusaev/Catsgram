package ru.yandex.practicum.catsgram.model;

import java.time.Instant;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@EqualsAndHashCode(of = {"email"})
public class User {

    Long id;
    String username;
    String email;
    String password;
    Instant registrationDate;
}

package ru.yandex.practicum.catsgram.dto.userdto;

import lombok.Data;

@Data
public class NewUserRequest {
    private String username;
    private String email;
    private String password;
}

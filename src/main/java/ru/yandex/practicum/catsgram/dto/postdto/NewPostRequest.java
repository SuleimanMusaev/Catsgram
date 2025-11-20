package ru.yandex.practicum.catsgram.dto.postdto;

import lombok.Data;

@Data
public class NewPostRequest {
    private long authorId;
    private String description;
}

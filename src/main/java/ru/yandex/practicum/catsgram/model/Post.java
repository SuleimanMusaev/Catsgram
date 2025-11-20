package ru.yandex.practicum.catsgram.model;

import java.time.Instant;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id"})
public class Post {
    private Long id;
    private User author;
    private String description;
    private Instant postDate;
    private List<Image> images;
}

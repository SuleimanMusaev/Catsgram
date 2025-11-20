package ru.yandex.practicum.catsgram.dto.postdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.yandex.practicum.catsgram.dto.userdto.UserDto;

import java.time.Instant;
import java.util.List;

@Data
public class PostDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;
    private UserDto author;
    private String description;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant postDate;
    private List<Long> images;
}

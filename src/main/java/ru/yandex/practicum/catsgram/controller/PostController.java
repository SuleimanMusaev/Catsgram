package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exception.ParameterNotValidException;
import ru.yandex.practicum.catsgram.model.enums.SortOrder;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public Collection<Post> findAll(@RequestParam(defaultValue = "0") int from,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "desc") String sort) {
        SortOrder sortOrder = SortOrder.from(sort);
        if (size <= 0) {
            throw new ParameterNotValidException("size",
                    "Некорректный размер выборки. Размер должен быть больше нуля");
        }
        if (from < 0) {
            throw new ParameterNotValidException("from",
                    "Некорректное значение смещения. Оно не может быть отрицательным");
        }
        if (sort == null || sort.isBlank()) {
            throw new ParameterNotValidException("sort",
                    "Параметр сортировки не может быть пустым");
        }
        return postService.findAll(from, size, sortOrder);
    }

    @GetMapping("/{postId}")
    public Optional<Post> findById(@PathVariable long postId) {
        return postService.findById(postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping
    public Post update(@RequestBody Post newPost) {
        return postService.update(newPost);
    }
}

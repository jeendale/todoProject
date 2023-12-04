package com.todo.todoproject.todo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TodoResponseDto {
    private Long id;
    private String title;
    private String content;

    public TodoResponseDto(Todo todo) {
        this.id= todo.getId();
        this.title=todo.getTitle();
        this.content=todo.getContent();
    }
}

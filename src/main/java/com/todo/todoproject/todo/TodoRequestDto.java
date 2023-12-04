package com.todo.todoproject.todo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequestDto {
    private String title;
    private String content;
}

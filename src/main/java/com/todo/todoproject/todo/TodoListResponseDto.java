package com.todo.todoproject.todo;

import com.todo.todoproject.user.User;
import com.todo.todoproject.user.UserDto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoListResponseDto {
    private UserDto user;
    private List<TodoResponseDto> todoList;

    public TodoListResponseDto(UserDto user, List<TodoResponseDto> todoList) {
        this.user = user;
        this.todoList = todoList;
    }
}

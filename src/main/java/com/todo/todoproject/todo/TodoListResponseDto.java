package com.todo.todoproject.todo;

import com.todo.todoproject.user.User;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoListResponseDto {
    private User user;
    private List<TodoResponseDto> todoList;


}

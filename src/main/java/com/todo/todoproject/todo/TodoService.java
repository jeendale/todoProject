package com.todo.todoproject.todo;

import com.todo.todoproject.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final  TodoRepository todoRepository;

    public TodoResponseDto createTodo(TodoRequestDto dto, User user) {
        Todo todo=new Todo(dto);
        todo.setUser(user);
        todoRepository.save(todo);

        return  new TodoResponseDto(todo);
    }

}

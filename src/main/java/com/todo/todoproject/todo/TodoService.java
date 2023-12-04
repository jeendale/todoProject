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

    public TodoResponseDto getTodo(Long todoId) {
        Todo todo= todoRepository.findById(todoId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 todo입니다."));

        return new TodoResponseDto(todo);
    }
}

package com.todo.todoproject.todo;

import com.todo.todoproject.CommonResponseDto;
import com.todo.todoproject.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/todos")
@RestController
@RequiredArgsConstructor
public class TodoController {
    private  final TodoService todoService;
    @PostMapping
    public ResponseEntity<TodoResponseDto> postTodo(@RequestBody TodoRequestDto todoRequestDto,@AuthenticationPrincipal
        UserDetailsImpl userDetails){
        TodoResponseDto responseDto=todoService.createTodo(todoRequestDto,userDetails.getUser());
        return ResponseEntity.status(201).body(responseDto);
    }
    @GetMapping
    public ResponseEntity<Void> getTodoList(){
        return ResponseEntity.ok().build();
    }

}

package com.todo.todoproject.todo;

import com.todo.todoproject.CommonResponseDto;
import com.todo.todoproject.user.User;
import com.todo.todoproject.user.UserDetailsImpl;
import com.todo.todoproject.user.UserDto;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/{todoId}")
    public ResponseEntity<CommonResponseDto> getTodo(@PathVariable Long todoId){
       try {
           TodoResponseDto responseDto = todoService.getTodo(todoId);
           return ResponseEntity.ok().body(responseDto);
       }catch (IllegalArgumentException e){
           return  ResponseEntity.badRequest().body(new CommonResponseDto(e.getMessage(),HttpStatus.BAD_REQUEST.value()));
       }

    }
    @GetMapping
    public ResponseEntity<Map<UserDto, List<TodoResponseDto>>> getTodoMap(){
        Map<UserDto, List<TodoResponseDto>> responseDtoList=todoService.getUserTodoMap();
        return ResponseEntity.ok().body(responseDtoList);
    }

}

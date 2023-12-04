package com.todo.todoproject.todo;

import com.todo.todoproject.CommonResponseDto;
import com.todo.todoproject.user.UserDto;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TodoResponseDto extends CommonResponseDto {
    private Long id;

    private String title;

    private String content;

    private boolean isCompleted;

    private UserDto user;

    private LocalDateTime createDate;
    public TodoResponseDto(Todo todo) {
        this.id= todo.getId();
        this.title=todo.getTitle();
        this.content=todo.getContent();
        this.isCompleted=todo.getIsCompleted();
        this.user=new UserDto(todo.getUser());
        this.createDate=todo.getCreateDate();
    }
}

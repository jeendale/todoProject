package com.todo.todoproject.comment;

import com.todo.todoproject.todo.Todo;
import com.todo.todoproject.todo.TodoRepository;
import com.todo.todoproject.todo.TodoRequestDto;
import com.todo.todoproject.todo.TodoResponseDto;
import com.todo.todoproject.todo.TodoService;
import com.todo.todoproject.user.User;
import com.todo.todoproject.user.UserDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository  commentRepository;
    private final TodoService todoService;
    public CommentResponseDto createComment(CommentRequestDto dto, User user) {
        Todo todo = todoService.getTodo(dto.getTodoId());

        Comment comment=new Comment(dto);
        comment.setUser(user);
        comment.setTodo(todo);
        commentRepository.save(comment);

        return new CommentResponseDto(comment);
    }


    @Transactional
    public CommentResponseDto updateComment(Long commentId,CommentRequestDto commentRequestDto, User user) {
        Comment comment=getUserComment(commentId,user);

        comment.setText(commentRequestDto.getText());

        return new CommentResponseDto(comment);
    }


    public void deleteComment(Long commentId, User user) {
        Comment comment = getUserComment(commentId, user);

        commentRepository.delete(comment);
    }

    private Comment getUserComment(Long commentId, User user) {
        Comment comment=commentRepository.findById(commentId).orElseThrow(()->new IllegalArgumentException("존재하지 않은 댓글 ID입니다."));

        if(!user.getId().equals(comment.getUser().getId())){
            throw new RejectedExecutionException("작성자만 수정할 수 있습니다.");
        }
        return comment;
    }


}

package com.todo.todoproject.comment;

import com.todo.todoproject.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}

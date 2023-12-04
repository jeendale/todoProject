package com.todo.todoproject.todo;

import com.todo.todoproject.comment.Comment;
import com.todo.todoproject.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private LocalDateTime createDate;

    @Column
    private Boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "todo")
    private List<Comment> comments;

    public Todo(TodoRequestDto dto) {
        this.title=dto.getTitle();
        this.content=dto.getContent();
        this.createDate=LocalDateTime.now();
        this.isCompleted=false;
    }

    //연관관계 메사드
    public void setUser(User user){
        this.user=user;
       // user.getTodoList().add(this);
    }
    //서비스 메서드
    public void setTitle(String title){
        this.title=title;
    }
    public void  setContent(String content){
        this.content=content;
    }

    public void complete(){
        this.isCompleted=true;
    }
}

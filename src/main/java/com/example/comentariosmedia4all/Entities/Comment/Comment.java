package com.example.comentariosmedia4all.Entities.Comment;

import com.example.comentariosmedia4all.Entities.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;


    @Column(name = "Conteudo", nullable = false)
    private String conteudo;

    @Column(name = "Allow_replies")
    private Boolean allowReplies;

    @Enumerated(EnumType.STRING)
    @Column(name = "Comment_visibility", nullable = false)
    private CommentVisibility commentVisibility;

    @Column(name = "Allow_notifications")
    private Boolean allowNotifications;

    @Column(name = "Max_comments")
    private Integer maxComments;


    @Column(name = "Created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "Id_User", referencedColumnName = "Id", updatable = false, nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "AnswerOf", referencedColumnName = "Id",updatable = false)
    private Comment parentComment;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }



}

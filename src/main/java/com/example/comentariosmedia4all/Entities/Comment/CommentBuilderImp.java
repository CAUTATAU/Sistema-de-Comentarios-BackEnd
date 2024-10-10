package com.example.comentariosmedia4all.Entities.Comment;

import com.example.comentariosmedia4all.DTOs.CommentDTO;
import com.example.comentariosmedia4all.Entities.User.User;
import com.example.comentariosmedia4all.Repositories.CommentRepository;
import com.example.comentariosmedia4all.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentBuilderImp implements CommentBuilder {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment buildComment(CommentDTO data) {
        Comment comment = new Comment();
        comment.setConteudo(data.conteudo());
        User author = userService.findById(data.userId());
        comment.setUser(author);
        comment.setCommentVisibility(data.commentVisibility());
        Comment parentComment = commentRepository.findById(data.answerOf()).orElse(null);
        comment.setParentComment(parentComment);
        comment.setAllowReplies(data.allowReplies());
        return comment;
    }
}

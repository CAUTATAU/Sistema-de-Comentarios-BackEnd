package com.example.comentariosmedia4all.Services;

import com.example.comentariosmedia4all.DTOs.CommentDTO;
import com.example.comentariosmedia4all.DTOs.EditCommentDTO;
import com.example.comentariosmedia4all.Entities.Comment.Comment;
import com.example.comentariosmedia4all.Entities.Comment.CommentBuilder;
import com.example.comentariosmedia4all.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentBuilder commentBuilder;

    public Comment createComment(CommentDTO commentData) {
        Comment comment = commentBuilder.buildComment(commentData);
        if(comment.getParentComment()!=null && !comment.getParentComment().getAllowReplies()) throw new RuntimeException("respostas indisponiveis");
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public String updateComment(Integer id, EditCommentDTO newText) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if(commentOptional.isPresent()) {
            Comment comment = commentOptional.get();
            comment.setConteudo(newText.conteudo());
            commentRepository.save(comment);
            return newText.conteudo();
        }
        throw new RuntimeException("Comentário não encontrado.");
    }

    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }



}

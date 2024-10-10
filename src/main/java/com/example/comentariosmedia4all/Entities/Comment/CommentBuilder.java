package com.example.comentariosmedia4all.Entities.Comment;

import com.example.comentariosmedia4all.DTOs.CommentDTO;

public interface CommentBuilder {
    Comment buildComment(CommentDTO data);
}

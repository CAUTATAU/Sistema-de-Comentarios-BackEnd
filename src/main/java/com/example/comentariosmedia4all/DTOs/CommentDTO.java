package com.example.comentariosmedia4all.DTOs;

import com.example.comentariosmedia4all.Entities.Comment.CommentVisibility;

public record CommentDTO(Integer userId,
                         String conteudo,
                         Boolean allowReplies,
                         CommentVisibility commentVisibility,
                         Boolean allowNotifications,
                         Integer answerOf
                         ) {
}

package com.example.comentariosmedia4all.Entities.Comment;

import lombok.Getter;

@Getter
public enum CommentVisibility {
    TODOS("TODOS"),
    ADM("ADM"),
    SIGNATARIOS("SIGNATARIOS");

    private String visibility;
    CommentVisibility(String visibility) {
        this.visibility = visibility;
    }
}

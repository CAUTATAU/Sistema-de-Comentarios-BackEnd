package com.example.comentariosmedia4all.Entities.User;

import lombok.Getter;

@Getter
public enum Role {
    SIGNATARIO("SIGNATARIO"),
    ADM("ADM");

    private String role;
    Role(String role) {
        this.role = role;
    }

}

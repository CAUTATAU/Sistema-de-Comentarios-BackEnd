package com.example.comentariosmedia4all.Entities.User;

import com.example.comentariosmedia4all.DTOs.UserDTO;


public interface UserFactory {
    User createUser(UserDTO user);
}

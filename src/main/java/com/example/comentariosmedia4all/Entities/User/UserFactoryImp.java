package com.example.comentariosmedia4all.Entities.User;

import com.example.comentariosmedia4all.DTOs.UserDTO;
import org.springframework.stereotype.Component;


@Component
public class UserFactoryImp implements UserFactory {
    @Override
    public User createUser(UserDTO userDTO) {
        return new User(userDTO);
    }
}

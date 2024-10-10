package com.example.comentariosmedia4all.Services;

import com.example.comentariosmedia4all.DTOs.DTOFactory;
import com.example.comentariosmedia4all.DTOs.LoginDTO;
import com.example.comentariosmedia4all.DTOs.LoginResponseDTO;
import com.example.comentariosmedia4all.DTOs.UserDTO;
import com.example.comentariosmedia4all.Entities.User.User;
import com.example.comentariosmedia4all.Entities.User.UserFactory;
import com.example.comentariosmedia4all.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFactory userFactory;
    @Autowired
    private DTOFactory dtoFactory;

    public User createUser(UserDTO user) {
        User newUser = userFactory.createUser(user);
        return userRepository.save(newUser);
    }

    public LoginResponseDTO loginUser(LoginDTO userName) {
        User user = userRepository.findByName(userName.Name());
        return user!=null?dtoFactory.createLoginResponseDTO(user.getName(),user.getRole()):null;
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

}

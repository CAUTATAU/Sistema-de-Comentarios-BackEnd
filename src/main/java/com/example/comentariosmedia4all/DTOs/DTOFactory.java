package com.example.comentariosmedia4all.DTOs;

import com.example.comentariosmedia4all.Entities.User.Role;
import org.springframework.stereotype.Component;

@Component
public class DTOFactory {
   public LoginResponseDTO createLoginResponseDTO(String name, Role role) {
       return new LoginResponseDTO(name,role);
   }
}

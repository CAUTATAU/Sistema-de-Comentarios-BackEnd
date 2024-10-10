package com.example.comentariosmedia4all.Controllers;

import com.example.comentariosmedia4all.DTOs.LoginDTO;
import com.example.comentariosmedia4all.DTOs.LoginResponseDTO;
import com.example.comentariosmedia4all.DTOs.UserDTO;
import com.example.comentariosmedia4all.Entities.User.User;
import com.example.comentariosmedia4all.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody UserDTO userData) {
        User newUser = userService.createUser(userData);
        return ResponseEntity.ok(newUser.getName()+" Criado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginDTO userData) {
        LoginResponseDTO data = userService.loginUser(userData);
        return data!=null?ResponseEntity.ok(data):ResponseEntity.notFound().build();
    }
}

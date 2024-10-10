package com.example.comentariosmedia4all.Entities.User;

import com.example.comentariosmedia4all.DTOs.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false, name = "Name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "Role")
    private com.example.comentariosmedia4all.Entities.User.Role Role;

    public User(UserDTO userdata){
        this.name = userdata.Name();
        this.Role = userdata.role();
    }
}

package com.example.comentariosmedia4all.Repositories;

import com.example.comentariosmedia4all.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByName(String name);
}

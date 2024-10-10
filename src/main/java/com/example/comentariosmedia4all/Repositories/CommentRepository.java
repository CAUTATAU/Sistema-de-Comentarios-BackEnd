package com.example.comentariosmedia4all.Repositories;

import com.example.comentariosmedia4all.Entities.Comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}

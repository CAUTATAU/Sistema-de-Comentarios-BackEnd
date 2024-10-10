package com.example.comentariosmedia4all.Controllers;

import com.example.comentariosmedia4all.DTOs.CommentDTO;
import com.example.comentariosmedia4all.Entities.Comment.Comment;
import com.example.comentariosmedia4all.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody CommentDTO commendData) {
        Comment newComment = commentService.createComment(commendData);
        return ResponseEntity.ok(newComment);
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }
}

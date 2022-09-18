package com.dislinkt.postservice.controller;

import com.dislinkt.postservice.dto.CommentDTO;
import com.dislinkt.postservice.model.Comment;
import com.dislinkt.postservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/saveComment")
    public Comment saveComment(@RequestBody CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setCommentText(commentDTO.getCommentText());
        comment.setUsername(commentDTO.getUsername());
        comment.setCommentDate(commentDTO.getCommentDate());
        comment.setUserPost(commentService.getPostById(commentDTO.getUserPostId()));

        return commentService.saveComment(comment);
    }

    @GetMapping("/getAllComments")
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }
}

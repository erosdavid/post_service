package com.dislinkt.postservice.controller;

import com.dislinkt.postservice.dto.CommentDTO;
import com.dislinkt.postservice.model.Comment;
import com.dislinkt.postservice.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @PostMapping("/saveComment")
    public Comment saveComment(@RequestBody CommentDTO commentDTO){
        LOGGER.info("Saving new comment on post " + commentDTO.getUserPostId() + " from user " + commentDTO.getUsername());
        Comment comment = new Comment();
        comment.setCommentText(commentDTO.getCommentText());
        comment.setUsername(commentDTO.getUsername());
        comment.setCommentDate(commentDTO.getCommentDate());
        comment.setUserPost(commentService.getPostById(commentDTO.getUserPostId()));

        return commentService.saveComment(comment);
    }

    @GetMapping("/getAllComments")
    public List<Comment> getAllComments(){

        LOGGER.info("Getting all comments");
        return commentService.getAllComments();
    }
}

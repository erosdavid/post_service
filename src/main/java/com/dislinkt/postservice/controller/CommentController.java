package com.dislinkt.postservice.controller;

import com.dislinkt.postservice.model.Comment;
import com.dislinkt.postservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/saveComment")
    public Comment saveComment(@RequestBody Comment comment){
        return commentService.saveComment(comment);
    }

    @GetMapping("/getAllComments")
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }
}

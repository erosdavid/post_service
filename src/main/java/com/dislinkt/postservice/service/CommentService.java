package com.dislinkt.postservice.service;


import com.dislinkt.postservice.model.Comment;
import com.dislinkt.postservice.model.UserPost;
import com.dislinkt.postservice.repository.CommentRepository;
import com.dislinkt.postservice.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserPostRepository userPostRepository;

    public Comment saveComment(@RequestBody Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public UserPost getPostById(Long id){
        return userPostRepository.findById(id).get();

    }


}

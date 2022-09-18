package com.dislinkt.postservice.controller;

import com.dislinkt.postservice.dto.UserPostDTO;
import com.dislinkt.postservice.model.UserPost;
import com.dislinkt.postservice.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserPostController {
    @Autowired
    private UserPostService userPostService;

    @PostMapping("/saveUserPost")
    public UserPost saveUserPost(@RequestBody UserPostDTO userPostDTO){

        UserPost userPost = new UserPost();
        userPost.setPostText(userPostDTO.getPostText());
        userPost.setPostDate(userPostDTO.getPostDate());
        userPost.setUsername(userPostDTO.getUsername());
        userPost.setPicture(userPost.getPicture());
        userPost.setLink(userPost.getLink());
        return userPostService.saveUserPost(userPost);


    }

    @GetMapping("/getAllUserPosts")
    public List<UserPost> getAllUserPosts(){
        return userPostService.getAllUserPosts();
    }
}

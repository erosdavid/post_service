package com.dislinkt.postservice.service;

import com.dislinkt.postservice.dto.UserPostDTO;
import com.dislinkt.postservice.model.Comment;
import com.dislinkt.postservice.model.DislikePost;
import com.dislinkt.postservice.model.LikePost;
import com.dislinkt.postservice.model.UserPost;
import com.dislinkt.postservice.repository.DislikePostRepository;
import com.dislinkt.postservice.repository.LikePostRepository;
import com.dislinkt.postservice.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserPostService {

    @Autowired
    private UserPostRepository userPostRepository;

    public UserPost saveUserPost(@RequestBody UserPost userPost){

        return userPostRepository.save(userPost);

    }

    public List<UserPost> getAllUserPosts(List<String> usernames){
        return userPostRepository.findByUsernameInOrderByPostDateDesc(usernames);
    }

}

package com.dislinkt.postservice.controller;

import com.dislinkt.postservice.dto.CommentDTO;
import com.dislinkt.postservice.dto.UserPostDTO;
import com.dislinkt.postservice.model.Comment;
import com.dislinkt.postservice.model.UserPost;
import com.dislinkt.postservice.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UserPostController {
    @Autowired
    private UserPostService userPostService;

    @PostMapping("/saveUserPost")
    public UserPost saveUserPost(@RequestBody UserPostDTO userPostDTO){

        UserPost userPost = new UserPost();
        userPost.setPostText(userPostDTO.getPostText());
        userPost.setPostDate(userPostDTO.getPostDate());
        userPost.setUsername(userPostDTO.getUsername());
        userPost.setPicture(userPostDTO.getPicture());
        userPost.setLink(userPostDTO.getLink());
        return userPostService.saveUserPost(userPost);


    }

    @PutMapping("/getAllUserPosts")
    public List<UserPostDTO> getAllUserPosts(@RequestBody List<String> usernames){
        List<UserPost> userPosts = userPostService.getAllUserPosts(usernames);
        return generateListDto(userPosts);
    }

    @GetMapping("/getAllPostsForUser/{username}")
    public List<UserPostDTO> getAllUserPosts(@PathVariable String username){
        List<String> usernames = new ArrayList<>();
        usernames.add(username);
        List<UserPost> userPosts = userPostService.getAllUserPosts(usernames);
        return generateListDto(userPosts);
    }
    private List<UserPostDTO> generateListDto(List<UserPost> userPosts) {
        List<UserPostDTO> userPostDTOS = new ArrayList();
        for (UserPost post : userPosts){
            UserPostDTO userPostDTO = new UserPostDTO();

            userPostDTO.setPostText(post.getPostText());
            userPostDTO.setPostDate(post.getPostDate());
            userPostDTO.setUsername(post.getUsername());
            userPostDTO.setPicture(post.getPicture());
            userPostDTO.setLink(post.getLink());

            userPostDTO.setPostDate(post.getPostDate());
            userPostDTO.setLikeCount(post.getLikePosts().size());
            userPostDTO.setDislikeCount(post.getDislikePosts().size());
            userPostDTO.setComments(new ArrayList<>());
            userPostDTO.setId(post.getId());

            for (Comment comment : post.getComments()){
                CommentDTO commentDTO = new CommentDTO();
                commentDTO.setCommentDate(comment.getCommentDate());
                commentDTO.setCommentText(comment.getCommentText());
                commentDTO.setUsername(comment.getUsername());
                userPostDTO.getComments().add(commentDTO);

            }

            userPostDTOS.add(userPostDTO);
        }
        return userPostDTOS;
    }
}

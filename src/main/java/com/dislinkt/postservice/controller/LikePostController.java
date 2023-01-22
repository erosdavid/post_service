package com.dislinkt.postservice.controller;


import com.dislinkt.postservice.dto.LikePostDTO;
import com.dislinkt.postservice.model.LikePost;

import com.dislinkt.postservice.service.LikePostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LikePostController {

    @Autowired
    private LikePostService likePostService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LikePostController.class);

    @PostMapping("/saveLikePost")
    public int saveLikePost(@RequestBody LikePostDTO likePostDTO){

        LOGGER.info("Adding like to post " + likePostDTO.getUserPostID() + " from user " + likePostDTO.getUsername());
        return likePostService.saveLikePost(likePostDTO);
    }

    @DeleteMapping("/deleteLikePost/{id}")
    public ResponseEntity<?> deleteLikePost(@PathVariable Long id){
        LOGGER.info("Removing like on post " + id);
        LikePost delete = likePostService.deleteLikePost(id);
        if (delete != null){
            LOGGER.error("Removing like on post " + id + " failed");
            return ResponseEntity.status(HttpStatus.OK).body(delete);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(delete);
    }

    @GetMapping("/getAllLikePosts")
    public List<LikePost> getAllLikePosts(){
        LOGGER.info("Getting all likes");
        return likePostService.getAllLikePosts();
    }
}

package com.dislinkt.postservice.controller;


import com.dislinkt.postservice.dto.LikePostDTO;
import com.dislinkt.postservice.model.LikePost;

import com.dislinkt.postservice.service.LikePostService;
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

    @PostMapping("/saveLikePost")
    public LikePost saveLikePost(@RequestBody LikePostDTO likePostDTO){
        return likePostService.saveLikePost(likePostDTO);
    }

    @DeleteMapping("/deleteLikePost/{id}")
    public ResponseEntity<?> deleteLikePost(@PathVariable Long id){
        LikePost delete = likePostService.deleteLikePost(id);
        if (delete != null){
            return ResponseEntity.status(HttpStatus.OK).body(delete);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(delete);
    }

    @GetMapping("/getAllLikePosts")
    public List<LikePost> getAllLikePosts(){
        return likePostService.getAllLikePosts();
    }
}

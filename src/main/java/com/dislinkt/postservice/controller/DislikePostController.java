package com.dislinkt.postservice.controller;

import com.dislinkt.postservice.dto.DislikePostDTO;
import com.dislinkt.postservice.model.DislikePost;
import com.dislinkt.postservice.model.LikePost;
import com.dislinkt.postservice.service.DislikePostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DislikePostController {

    @Autowired
    private DislikePostService dislikePostService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DislikePostController.class);

    @PostMapping("/saveDislikePost")
    public int saveDislikePost(@RequestBody DislikePostDTO dislikePostDTO){

        LOGGER.info("Adding dislike to post " + dislikePostDTO.getUserPostID() + " by user " + dislikePostDTO.getUsername());
        return dislikePostService.saveDislikePost(dislikePostDTO);
    }

    @DeleteMapping("/deleteDislikePost/{id}")
    public ResponseEntity<?> deleteDislikePost(@PathVariable Long id){
        LOGGER.info("Removing dislike on post " + id);
        DislikePost delete = dislikePostService.deleteDislikePost(id);
        if (delete != null){
            LOGGER.info("Removing dislike on post " + id + " failed");
            return ResponseEntity.status(HttpStatus.OK).body(delete);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(delete);
    }

    @GetMapping("/getAllDislikePosts")
    public List<DislikePost> getAllDislikePosts(){
        LOGGER.info("Getting all dislikes");
        return dislikePostService.getAllDislikePosts();
    }
}

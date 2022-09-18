package com.dislinkt.postservice.controller;

import com.dislinkt.postservice.dto.DislikePostDTO;
import com.dislinkt.postservice.model.DislikePost;
import com.dislinkt.postservice.model.LikePost;
import com.dislinkt.postservice.service.DislikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DislikePostController {

    @Autowired
    private DislikePostService dislikePostService;

    @PostMapping("/saveDislikePost")
    public DislikePost saveDislikePost(@RequestBody DislikePostDTO dislikePostDTO){
        return dislikePostService.saveDislikePost(dislikePostDTO);
    }

    @DeleteMapping("/deleteDislikePost/{id}")
    public ResponseEntity<?> deleteDislikePost(@PathVariable Long id){
        DislikePost delete = dislikePostService.deleteDislikePost(id);
        if (delete != null){
            return ResponseEntity.status(HttpStatus.OK).body(delete);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(delete);
    }

    @GetMapping("/getAllDislikePosts")
    public List<DislikePost> getAllDislikePosts(){
        return dislikePostService.getAllDislikePosts();
    }
}

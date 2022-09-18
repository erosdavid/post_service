package com.dislinkt.postservice.service;

import com.dislinkt.postservice.dto.DislikePostDTO;
import com.dislinkt.postservice.model.DislikePost;
import com.dislinkt.postservice.model.LikePost;
import com.dislinkt.postservice.repository.DislikePostRepository;
import com.dislinkt.postservice.repository.LikePostRepository;
import com.dislinkt.postservice.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DislikePostService {

    @Autowired
    private DislikePostRepository dislikePostRepository;

    @Autowired
    private UserPostRepository userPostRepository;

    @Autowired
    private LikePostRepository likePostRepository;

    public DislikePost saveDislikePost(@RequestBody DislikePostDTO dislikePostDTO){
        DislikePost dislikePost = new DislikePost(dislikePostDTO);
        dislikePost.setUserPost(userPostRepository.findById(dislikePostDTO.getUserPostID()).orElse(null));
        List<LikePost> likePosts = likePostRepository.findAll();
        for (LikePost l : likePosts){
            if (dislikePost.getUsername().equals(l.getUsername()) && dislikePost.getUserPost().getId() == l.getUserPost().getId()){
                likePostRepository.delete(l);
            }
        }

        return dislikePostRepository.save(dislikePost);
    }

    public DislikePost deleteDislikePost(Long id){
        DislikePost dislikePost = dislikePostRepository.findById(id).orElse(null);
        if (dislikePost != null){
            dislikePostRepository.deleteById(id);
            return dislikePost;
        }
        return null;
    }

    public List<DislikePost> getAllDislikePosts(){
        return dislikePostRepository.findAll();
    }
}

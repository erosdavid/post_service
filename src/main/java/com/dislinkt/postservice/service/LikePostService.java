package com.dislinkt.postservice.service;

import com.dislinkt.postservice.dto.LikePostDTO;
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
public class LikePostService {

    @Autowired
    private LikePostRepository likePostRepository;

    @Autowired
    private UserPostRepository userPostRepository;

    @Autowired
    private DislikePostRepository dislikePostRepository;

    public LikePost saveLikePost(@RequestBody LikePostDTO likePostDTO){
        LikePost likePost = new LikePost(likePostDTO);
        likePost.setUserPost(userPostRepository.findById(likePostDTO.getUserPostID()).orElse(null));
        List<DislikePost> dislikePosts = dislikePostRepository.findAll();
        for (DislikePost d : dislikePosts){
            if (likePost.getUsername().equals(d.getUsername()) && likePost.getUserPost().getId() == d.getUserPost().getId()){
                dislikePostRepository.delete(d);
            }
        }

        return likePostRepository.save(likePost);

    }

    public LikePost deleteLikePost(Long id){
        LikePost likePost = likePostRepository.findById(id).orElse(null);
        if (likePost != null){
            likePostRepository.deleteById(id);
            return likePost;
        }
        return null;
    }

    public List<LikePost> getAllLikePosts(){
        return likePostRepository.findAll();
    }
}

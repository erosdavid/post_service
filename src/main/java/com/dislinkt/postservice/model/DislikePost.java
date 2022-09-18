package com.dislinkt.postservice.model;

import com.dislinkt.postservice.dto.DislikePostDTO;
import com.dislinkt.postservice.dto.LikePostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dislike_post")
public class DislikePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "username", nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "user_post")
    private UserPost userPost;

    public DislikePost(DislikePostDTO dislikePostDTO){
        this.username=dislikePostDTO.getUsername();
    }


}

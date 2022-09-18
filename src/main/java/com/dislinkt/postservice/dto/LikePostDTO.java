package com.dislinkt.postservice.dto;

import com.dislinkt.postservice.model.UserPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LikePostDTO {
    private String username;
    private Long userPostID;
}

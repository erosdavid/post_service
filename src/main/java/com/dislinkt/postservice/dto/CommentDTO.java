package com.dislinkt.postservice.dto;

import com.dislinkt.postservice.model.UserPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class CommentDTO {
    private String commentText;
    private String username;
    private Long userPostId;
    private Date commentDate;

    public CommentDTO(){
        this.commentDate = new Date();
    }
}

package com.dislinkt.postservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserPostDTO {
    private String postText;
    private String picture;
    private String link;
    private String username;
}

package com.dislinkt.postservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_post")
public class UserPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_text", nullable = false)
    private String postText;

    @Lob
    @Column(name = "picture", nullable = true)
    private String picture;

    @Column(name = "link", nullable = true)
    private String link;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "post_date", nullable = false)
    private Date postDate;

    @JsonIgnore
    @OneToMany(mappedBy = "userPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LikePost> likePosts;

    @JsonIgnore
    @OneToMany(mappedBy = "userPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DislikePost> dislikePosts;

    @JsonIgnore
    @OneToMany(mappedBy = "userPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;






}

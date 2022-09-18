package com.dislinkt.postservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_text", nullable = false)
    private String commentText;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "comment_date", nullable = false)
    private Date commentDate;

    @ManyToOne
    @JoinColumn(name = "user_post")
    private UserPost userPost;

}
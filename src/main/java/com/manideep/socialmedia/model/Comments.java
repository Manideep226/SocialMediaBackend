package com.manideep.socialmedia.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name= "userid")
    private int userId;

    @Column(name="postid")
    private int postId;

    @Column(name="commentid")
    private int commentId;

    @Column(name="commentcontent")
    private String commentContent;
}

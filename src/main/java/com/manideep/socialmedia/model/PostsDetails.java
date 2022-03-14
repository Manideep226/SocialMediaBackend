package com.manideep.socialmedia.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="postdetails")
public class PostsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="userid")
    private int userid;

    @Column(name = "groupid")
    private int groupid;

    @Column(name = "postcontent")
    private String postContent;
}

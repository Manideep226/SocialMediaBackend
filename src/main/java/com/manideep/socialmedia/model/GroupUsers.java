package com.manideep.socialmedia.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="groups_users")
public class GroupUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="groupid")
    private int groupid;

    @Column(name="userid")
    private int userid;
}

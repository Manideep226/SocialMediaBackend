package com.manideep.socialmedia.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="groups_details")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="createdby")
    private int createdby;
}

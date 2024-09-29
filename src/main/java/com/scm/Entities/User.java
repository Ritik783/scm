package com.scm.Entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // private String userId;
    @Column(name = "userName",nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    private String password;
    @Column(length = 100000)
    private String about;

    @Column(length = 10000)
    private String profilePic;
    private String phoneNumer;
    // Information

    private Boolean enabled = false;
    private Boolean emailverified = false;
    private Boolean phoneVerified = false;
    // Self,google,linkedIn,twitter,facebook  
    private Provider provider=Provider.SELF;
    private String providerId;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Contact> contactList = new ArrayList<>();

   
}

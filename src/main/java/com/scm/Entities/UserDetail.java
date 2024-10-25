package com.scm.Entities;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name="user")
public class UserDetail implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // private String userId;
    @Column(name = "userName",nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    @Getter(AccessLevel.NONE)
    private String password;
    @Column(length = 100000)
    private String about;

    @Column(length = 10000)
    private String profilePic;
    private String phoneNumber;
    // Information

    private Boolean enabled = true;
    private Boolean emailverified = false;
    private Boolean phoneVerified = false;
    // Self,google,linkedIn,twitter,facebook
    @Enumerated(value = EnumType.STRING)
    private Provider provider;
    private String providerId;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Contact> contactList = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roleList = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> newRoleList =
                roleList.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
        return newRoleList;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
    @Override
    public boolean isEnabled(){
        return this.enabled;
    }
    @Override
    public String getPassword(){
        return this.password;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public  boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}

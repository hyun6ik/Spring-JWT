package com.example.jwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter  @Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {

    @JsonIgnore
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 50, unique = true)
    private String username;

    @JsonIgnore
    @Column(length = 100)
    private String password;

    @Column(length = 100)
    private String nickname;

    @JsonIgnore
    private boolean activated;


    @OneToMany(mappedBy = "user")
    private List<UserAndAuthority> userAndAuthorities = new ArrayList<>();




}

package com.example.jwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserAndAuthority {

    @JsonIgnore
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authority_id")
    private Authority authority;


    //연관 관계 메소드
    public void addUser(User user){
        user.getUserAndAuthorities().add(this);
        this.setUser(user);
    }
    public void addAuthority(Authority authority){
        authority.getUserAndAuthorities().add(this);
        this.setAuthority(authority);
    }

//    public UserAndAuthority createUserAndAuthority(User user, Authority authority){
//        UserAndAuthority userAndAuthority = new UserAndAuthority();
//        userAndAuthority.addUser(user);
//        userAndAuthority.addAuthority(authority);
//        return userAndAuthority;
//    }
}

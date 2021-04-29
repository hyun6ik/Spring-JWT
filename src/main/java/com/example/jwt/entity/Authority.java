package com.example.jwt.entity;

import lombok.*;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authority {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Long id;

    private String authorityName;

    @OneToMany(mappedBy = "authority")
    private List<UserAndAuthority> userAndAuthorities = new ArrayList<>();


}

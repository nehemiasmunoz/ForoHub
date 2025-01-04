package com.marvic.forohub.entities.user;

import com.marvic.forohub.entities.profile.Profile;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = 100)
    private String username;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 300)
    private String password;
    @Transient
    @ManyToMany
    @Column(nullable = false)
    private Set<Profile> profiles;
}

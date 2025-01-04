package com.marvic.forohub.entities.profile;

import com.marvic.forohub.entities.user.User;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Transient
    @ManyToMany
    private Set<User> users;
}

package com.marvic.forohub.entities.user;

import com.marvic.forohub.dtos.user.NewUserDTO;
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
    @ManyToMany
    @Column(nullable = false)
    private Set<Profile> profiles;

    public User() {
    }

    public User(long id, String username, String email, String password, Set<Profile> profiles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profiles = profiles;
    }

    public User(NewUserDTO newUserDTO) {
        this.username = newUserDTO.username();
        this.email = newUserDTO.email();
        this.password = newUserDTO.password();
        this.profiles = newUserDTO.profiles();
    }


    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }
}

package com.marvic.forohub.entities.profile;

import com.marvic.forohub.dtos.profile.NewProfileDTO;
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
    
    @ManyToMany
    private Set<User> users;

    public Profile() {
    }

    public Profile(long id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Profile(NewProfileDTO newProfileDTO) {
        this.name = newProfileDTO.name();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

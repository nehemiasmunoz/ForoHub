package com.marvic.forohub.dtos.user;

import com.marvic.forohub.entities.profile.Profile;
import com.marvic.forohub.entities.user.User;

import java.util.Set;

public record UserDTO(
        Long id,
        String username,
        String email,
        String password,
        Set<Profile> profiles
) {
    public UserDTO(User user) {
        this(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getProfiles());
    }
}

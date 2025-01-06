package com.marvic.forohub.dtos.user;

import com.marvic.forohub.entities.profile.Profile;

import java.util.Set;

public record NewUserDTO(
        String username,
        String email,
        String password,
        Set<Profile> profiles
) {
}

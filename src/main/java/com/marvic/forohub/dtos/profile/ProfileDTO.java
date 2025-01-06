package com.marvic.forohub.dtos.profile;

import com.marvic.forohub.entities.profile.Profile;

public record ProfileDTO(
        Long id,
        String name
) {
    public ProfileDTO(Profile profile) {
        this(profile.getId(), profile.getName());
    }
}

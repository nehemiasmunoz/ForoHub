package com.marvic.forohub.dtos.profile;

import jakarta.validation.constraints.NotBlank;

public record NewProfileDTO(
        @NotBlank
        String name
) {
}

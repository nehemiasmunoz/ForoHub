package com.marvic.forohub.dtos.course;

import jakarta.validation.constraints.NotBlank;

public record NewCourseDTO(
        @NotBlank
        String name,
        @NotBlank
        String category
) {
}

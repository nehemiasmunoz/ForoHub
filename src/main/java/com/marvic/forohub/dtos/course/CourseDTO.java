package com.marvic.forohub.dtos.course;

import com.marvic.forohub.entities.course.Course;

public record CourseDTO(
        Long id,
        String name,
        String category
) {
    public CourseDTO(Course course) {
        this(course.getId(), course.getName(), course.getCategory());
    }
}

package com.marvic.forohub.service.course.inter;

import com.marvic.forohub.dtos.course.CourseDTO;
import com.marvic.forohub.dtos.course.NewCourseDTO;

import java.util.Optional;
import java.util.Set;

public interface ICourseService {

    Set<CourseDTO> getCourses();

    Optional<CourseDTO> getCourseById(Long id);

    CourseDTO createCourse(NewCourseDTO course);
}

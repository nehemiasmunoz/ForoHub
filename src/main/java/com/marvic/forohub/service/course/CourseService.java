package com.marvic.forohub.service.course;

import com.marvic.forohub.dtos.course.CourseDTO;
import com.marvic.forohub.dtos.course.NewCourseDTO;
import com.marvic.forohub.entities.course.Course;
import com.marvic.forohub.exceptions.DataNotFoundException;
import com.marvic.forohub.repository.CourseRepository;
import com.marvic.forohub.service.course.inter.ICourseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService implements ICourseService {

    private final CourseRepository courseRepository;

    CourseService(CourseRepository repo) {
        this.courseRepository = repo;
    }

    @Override
    public Set<CourseDTO> getCourses() {
        final Set<CourseDTO> courseDTOS = courseRepository.findAll().stream()
                .map(CourseDTO::new)
                .collect(Collectors.toSet());
        if (courseDTOS.isEmpty()) throw new DataNotFoundException("Sin registros existentes");
        return courseDTOS;
    }

    @Override
    public Optional<CourseDTO> getCourseById(Long id) {
        final Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return Optional.of(new CourseDTO(course.get()));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public CourseDTO createCourse(NewCourseDTO course) {
        return new CourseDTO(courseRepository.save(new Course(course)));
    }
}

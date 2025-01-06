package com.marvic.forohub.restcontroller.course;

import com.marvic.forohub.dtos.course.CourseDTO;
import com.marvic.forohub.dtos.course.NewCourseDTO;
import com.marvic.forohub.service.course.inter.ICourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/rest/courses")
public class CourseRestController {

    private final ICourseService courseService;

    CourseRestController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public ResponseEntity<Set<CourseDTO>> getCourses() {
        return ResponseEntity.ok(courseService.getCourses());
    }

    @PostMapping("/save")
    public ResponseEntity<CourseDTO> saveCourses(@RequestBody @Valid NewCourseDTO course) {
        return ResponseEntity.ok(courseService.createCourse(course));
    }
}

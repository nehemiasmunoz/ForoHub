package com.marvic.forohub.entities.course;

import com.marvic.forohub.dtos.course.NewCourseDTO;
import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 90)
    private String category;

    public Course() {
    }

    public Course(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Course(NewCourseDTO newCourseDTO) {
        this.name = newCourseDTO.name();
        this.category = newCourseDTO.category();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

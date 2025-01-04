package com.marvic.forohub.entities.topic;

import com.marvic.forohub.entities.course.Course;
import com.marvic.forohub.entities.response.TopicResponse;
import com.marvic.forohub.entities.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 250)
    private String message;
    @Column(nullable = false)
    private LocalDate createAt;
    @Column(nullable = false)
    private boolean status;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    private User author;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Course.class)
    private Course course;
    @OneToMany(mappedBy = "topic")
    private Set<TopicResponse> responses;

}

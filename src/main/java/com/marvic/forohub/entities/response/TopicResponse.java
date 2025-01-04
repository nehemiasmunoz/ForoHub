package com.marvic.forohub.entities.response;

import com.marvic.forohub.entities.topic.Topic;
import com.marvic.forohub.entities.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class TopicResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = 100)
    private String message;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Topic.class)
    private Topic topic;
    @Column(nullable = false)
    private LocalDate createdAt;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    private User author;
    @Column(nullable = false, length = 300)
    private String solution;

}

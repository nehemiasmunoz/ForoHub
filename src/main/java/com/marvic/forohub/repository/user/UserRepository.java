package com.marvic.forohub.repository.user;

import com.marvic.forohub.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

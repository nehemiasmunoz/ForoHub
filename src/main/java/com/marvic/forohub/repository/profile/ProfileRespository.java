package com.marvic.forohub.repository.profile;

import com.marvic.forohub.entities.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRespository extends JpaRepository<Profile, Long> {
}

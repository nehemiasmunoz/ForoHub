package com.marvic.forohub.service.profile;

import com.marvic.forohub.dtos.profile.NewProfileDTO;
import com.marvic.forohub.dtos.profile.ProfileDTO;
import com.marvic.forohub.entities.profile.Profile;
import com.marvic.forohub.exceptions.DataNotFoundException;
import com.marvic.forohub.repository.profile.ProfileRespository;
import com.marvic.forohub.service.profile.inter.IProfileService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProfileService implements IProfileService {

    private ProfileRespository profileRespository;

    ProfileService(ProfileRespository profileRespository) {
        this.profileRespository = profileRespository;
    }

    @Override
    public Set<ProfileDTO> getProfiles() {
        var profiles = profileRespository.findAll();
        if (profiles.isEmpty()) {
            throw new DataNotFoundException("Sin perfiles registrados.");
        }
        return profiles.stream().map(ProfileDTO::new).collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public ProfileDTO saveProfile(NewProfileDTO profile) {
        return new ProfileDTO(profileRespository.save(new Profile(profile)));
    }
}

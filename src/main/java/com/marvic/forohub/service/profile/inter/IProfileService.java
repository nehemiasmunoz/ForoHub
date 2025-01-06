package com.marvic.forohub.service.profile.inter;

import com.marvic.forohub.dtos.profile.NewProfileDTO;
import com.marvic.forohub.dtos.profile.ProfileDTO;

import java.util.Set;

public interface IProfileService {
    Set<ProfileDTO> getProfiles();

    ProfileDTO saveProfile(NewProfileDTO profile);
}

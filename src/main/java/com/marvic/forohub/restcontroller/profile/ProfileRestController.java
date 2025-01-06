package com.marvic.forohub.restcontroller.profile;

import com.marvic.forohub.dtos.profile.NewProfileDTO;
import com.marvic.forohub.dtos.profile.ProfileDTO;
import com.marvic.forohub.service.profile.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/rest/profiles")
public class ProfileRestController {

    private final ProfileService profileService;

    ProfileRestController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<Set<ProfileDTO>> getProfiles() {
        return ResponseEntity.ok(profileService.getProfiles());
    }

    @PostMapping("/save")
    public ResponseEntity<ProfileDTO> saveProfile(@RequestBody @Valid NewProfileDTO profileDTO) {
        return ResponseEntity.ok(profileService.saveProfile(profileDTO));
    }
}

package com.main.project_socket.controller;

import com.main.project_socket.entity.Profile;
import com.main.project_socket.entity.dto.ProfileBody;
import com.main.project_socket.service.ProfileServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileServices profileServices;

    @PostMapping("/create")
    public ResponseEntity<Profile> createProfile(@RequestBody @Valid ProfileBody body) {
        Profile createdProfile = profileServices.createdProfile(body);
        return ResponseEntity.ok(createdProfile);
    }
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteProfile(@RequestBody String email) {
        try {
            return profileServices.removeProfile(email)
                    ? ResponseEntity.status(HttpStatus.OK).build()
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
    @PostMapping("/update")
    public ResponseEntity<Profile> updateProfile(
            @RequestParam String setType,
            @RequestParam String value,
            @RequestParam String email) {

        try {
            Profile updatedProfile = profileServices.updateProfile(setType, value, email);
            return ResponseEntity.ok(updatedProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Profile>> defaultEndpoint() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(profileServices.getAllProfiles());
    }

}

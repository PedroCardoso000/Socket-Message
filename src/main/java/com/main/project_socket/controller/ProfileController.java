package com.main.project_socket.controller;

import com.main.project_socket.entity.Profile;
import com.main.project_socket.entity.dto.ProfileBody;
import com.main.project_socket.service.ProfileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/profile")
public class ProfileController {
    @Autowired
    private ProfileServices profileServices;

    @PostMapping("/create")
    public ResponseEntity<Profile> createProfile(ProfileBody body) {
        Profile createdProfile = profileServices.createdProfile(body);
        return ResponseEntity.ok(createdProfile);
    }
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteProfile(String email) {
        try {
            return profileServices.removeProfile(email)
                    ? ResponseEntity.status(HttpStatus.OK).build()
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
    @PostMapping("/update")
    public ResponseEntity<Profile> updateProfile(String setType, String value, String email) {
        try {
            Profile updatedProfile = profileServices.updateProfile(setType, value, email);
            return ResponseEntity.ok(updatedProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}

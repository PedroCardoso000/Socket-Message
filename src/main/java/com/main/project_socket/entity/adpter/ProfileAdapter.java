package com.main.project_socket.entity.adpter;

import com.main.project_socket.entity.Profile;
import com.main.project_socket.entity.dto.ProfileBody;
import org.springframework.stereotype.Component;

@Component
public class ProfileAdapter {

    public Profile getProfileEntity(ProfileBody body){
        Profile profile = new Profile();
        profile.setName(body.name());
        profile.setEmail(body.email());
        profile.setPhone(body.phone());
        // Converts ProfileBody to Profile entity
        return profile;
    }

    public ProfileBody getProfileBody(Profile profile){
        // Converts Profile entity to ProfileBody
        return new ProfileBody(profile.getName(), profile.getEmail(), profile.getPhone());
    }
}

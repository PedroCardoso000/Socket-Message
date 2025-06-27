package com.main.project_socket.service;

import com.main.project_socket.entity.Profile;
import com.main.project_socket.entity.adpter.ProfileAdapter;
import com.main.project_socket.entity.dto.ProfileBody;
import com.main.project_socket.interfaces.ProfileInterfaceService;
import com.main.project_socket.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServices implements ProfileInterfaceService {

    @Autowired
    private ProfileRepository repository;
    @Autowired
    private ProfileAdapter profileAdapter;


    @Override
    public Profile createdProfile(ProfileBody body) {
        return repository.save(profileAdapter.getProfileEntity(body));
    }

    @Override
    public Boolean removeProfile(String email) throws Exception{
        Optional<Profile> profile = Optional.ofNullable(Optional.ofNullable(repository.findByEmail(email))
                .orElseThrow(() -> new UserPrincipalNotFoundException("Profile not found with email: " + email)));

        if (profile.isPresent()) {
            repository.delete(profile.get());
            return true;
        }

        return false;
    }

    @Override
    public Profile updateProfile(String setType, String value, String email) throws Exception {
        Profile existingProfile = Optional.ofNullable(repository.findByEmail(email))
                .orElseThrow(() -> new UserPrincipalNotFoundException("Profile not found with email: " + email));

        switch (setType.toLowerCase()) {
            case "name" -> existingProfile.setName(value);
            case "email" -> existingProfile.setEmail(value);
            case "phone" -> existingProfile.setPhone(value);
            default -> throw new IllegalArgumentException("Invalid field type: " + setType);
        }

        return repository.save(existingProfile);
    }

    public List<Profile> getAllProfiles() {
        return repository.findAll();
    }

}

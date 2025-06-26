package com.main.project_socket.service;

import com.main.project_socket.entity.Profile;
import com.main.project_socket.interfaces.ProfileInterfaceService;
import com.main.project_socket.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServices implements ProfileInterfaceService {

    @Autowired
    private ProfileRepository repository;

    @Override
    public Profile createdProfile(String name, String email, String phone) {

        return null;
    }

    @Override
    public Boolean removeProfile(String email) {
        return null;
    }

    @Override
    public Profile updateProfile(String setType, String value, String email) {
        return null;
    }
}

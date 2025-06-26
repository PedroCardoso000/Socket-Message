package com.main.project_socket.interfaces;

import com.main.project_socket.entity.Profile;

public interface ProfileInterfaceService {
    Profile createdProfile(String name, String email, String phone);
    Boolean removeProfile(String email);
    // Field to identify the value that will be changed
    Profile updateProfile(String setType, String value, String email);
}

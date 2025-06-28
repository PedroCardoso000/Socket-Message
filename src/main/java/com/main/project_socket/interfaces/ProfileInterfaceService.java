package com.main.project_socket.interfaces;

import com.main.project_socket.entity.Profile;
import com.main.project_socket.entity.dto.ProfileBody;


public interface ProfileInterfaceService {
    Profile createdProfile(ProfileBody body);
    Boolean removeProfile(String email) throws Exception;
    // Field to identify the value that will be changed
    Profile updateProfile(String setType, String value, String email) throws Exception;
}

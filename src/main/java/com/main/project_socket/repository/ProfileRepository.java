package com.main.project_socket.repository;


import com.main.project_socket.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository  extends JpaRepository<Profile, Long> {

    // Method to find a profile by email
    Profile findByEmail(String email);

    // Method to delete a profile by email
    void deleteByEmail(String email);

    Optional<Profile> findByName(String name);
}

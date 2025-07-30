

package com.main.project_socket.controller;

import com.main.project_socket.entity.Profile;
import com.main.project_socket.entity.dto.JwtResponse;
import com.main.project_socket.entity.dto.LoginRequest;
import com.main.project_socket.entity.dto.RegisterRequest;
import com.main.project_socket.repository.ProfileRepository;
import com.main.project_socket.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

            String token = jwtUtil.generateToken(request.getEmail());

            return ResponseEntity.ok(new JwtResponse(token));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        Optional<Profile> existing = profileRepository.findByEmail(request.getEmail());
        if (existing.isEmpty()) {
            return ResponseEntity.badRequest().body("Email already in use.");
        }

        Profile profile = new Profile();
        profile.setName(request.getName());
        profile.setEmail(request.getEmail());
        profile.setPassword(passwordEncoder.encode(request.getPassword()));
        profile.setPhone(request.getPhone());

        profileRepository.save(profile);

        return ResponseEntity.ok("User registered successfully.");
    }

}

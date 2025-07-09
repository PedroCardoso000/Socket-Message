package com.main.project_socket.security;


import com.main.project_socket.entity.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Exemplo fixo (troque para seu UserRepository)
        if ("user".equals(username)) {
          //  return new Profile("user", "{noop}1234", Collections.emptyList());
        }
        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}

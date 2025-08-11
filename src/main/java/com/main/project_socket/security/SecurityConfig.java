
package com.main.project_socket.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())              // Desativa CSRF (comum em APIs REST)
                .cors(cors -> cors.disable())                // Desativa CORS (configure depois se precisar)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**", "/**").permitAll() // Permite rotas públicas (login, cadastro, etc)
                        .anyRequest().authenticated()             // Protege todas as outras rotas
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // API sem sessão (stateless)
                );

        // Adiciona o filtro JWT antes do filtro padrão de autenticação
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

//        http.cors(AbstractHttpConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/login", "/auth/**", "/css/**", "/js/**").permitAll()
//                        .anyRequest().authenticated())
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/mensagem", true)
//                        .permitAll())
//                .rememberMe(remember -> remember
//                        .key("aSecretKeyForHashing")
//                        .tokenValiditySeconds(7 * 24 * 60 * 60)) // 7 days
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/login?logout")
//                        .permitAll());
//
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}




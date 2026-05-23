package com.control.inventario.config;

import com.control.inventario.security.CustomSuccessHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final CustomSuccessHandler customSuccessHandler;

    // CONSTRUCTOR
    public SecurityConfig(
            CustomSuccessHandler customSuccessHandler
    ) {

        this.customSuccessHandler = customSuccessHandler;
    }

    // PASSWORD ENCODER
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    // AUTH MANAGER
    @Bean
    public AuthenticationManager authenticationManager(

            AuthenticationConfiguration configuration

    ) throws Exception {

        return configuration.getAuthenticationManager();
    }

    // SEGURIDAD
    @Bean
    public SecurityFilterChain securityFilterChain(

            HttpSecurity http

    ) throws Exception {

        http

                // CSRF
                .csrf(csrf -> csrf.disable())

                // RUTAS
                .authorizeHttpRequests(auth -> auth

                        // PUBLICAS
                        .requestMatchers(

                                "/login",
                                "/registro",
                                "/guardar-usuario",

                                "/css/**",
                                "/js/**",
                                "/img/**"

                        ).permitAll()

                        // ADMIN
                        .requestMatchers(

                                "/admin/**"

                        ).hasRole("ADMIN")

                        // USUARIO
                        .requestMatchers(

                                "/dashboard",
                                "/reservar",
                                "/mis-reservas"

                        ).hasRole("USUARIO")

                        // RESTO
                        .anyRequest()

                        .authenticated()
                )

                // LOGIN
                .formLogin(form -> form

                        .loginPage("/login")

                        .loginProcessingUrl("/login")

                        .successHandler(customSuccessHandler)

                        .permitAll()
                )

                // LOGOUT
                .logout(logout -> logout

                        .logoutUrl("/logout")

                        .logoutSuccessUrl("/login?logout")

                        .permitAll()
                );

        return http.build();
    }
}
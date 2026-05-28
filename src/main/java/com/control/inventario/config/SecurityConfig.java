package com.control.inventario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
public class SecurityConfig {

    private final LoginSuccessHandler loginSuccessHandler;

    // CONSTRUCTOR
    public SecurityConfig(
            LoginSuccessHandler loginSuccessHandler) {

        this.loginSuccessHandler = loginSuccessHandler;
    }

    // ENCRIPTAR PASSWORD
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    // CONFIGURACION SEGURIDAD
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http

            // AUTORIZACIONES
            .authorizeHttpRequests(auth -> auth

                // RECURSOS PUBLICOS
                .requestMatchers(
                        "/css/**",
                        "/js/**",
                        "/img/**",
                        "/registro",
                        "/guardar-usuario",
                        "/login"
                ).permitAll()

                // SOLO ADMIN
                .requestMatchers("/admin/**")
.hasRole("ADMIN")

                // CUALQUIER OTRA RUTA REQUIERE LOGIN
                .anyRequest()
                .authenticated()
            )

            // LOGIN
            .formLogin(form -> form

                .loginPage("/login")

                // REDIRECCION SEGUN ROL
                .successHandler(loginSuccessHandler)

                // ERROR LOGIN
                .failureUrl("/login?error")

                .permitAll()
            )

            // LOGOUT
            .logout(logout -> logout

                .logoutUrl("/logout")

                .logoutSuccessUrl("/login?logout")

                .invalidateHttpSession(true)

                .deleteCookies("JSESSIONID")

                .permitAll()
            )

            // CONTROL DE SESIONES
            .sessionManagement(session -> session

                // SOLO 1 SESION POR USUARIO
                .maximumSessions(1)

                // IMPIDE LOGIN EN OTRO DISPOSITIVO
                .maxSessionsPreventsLogin(true)

                // SI LA SESION EXPIRA
                .expiredUrl("/login?expired")
            );

        return http.build();
    }

    // CONTROLADOR DE EVENTOS DE SESION
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {

        return new HttpSessionEventPublisher();
    }
}
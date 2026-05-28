package com.control.inventario.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginSuccessHandler
        implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication)

            throws IOException, ServletException {

        // SI ES ADMIN
        if (authentication.getAuthorities()
                .contains(new SimpleGrantedAuthority("ADMIN"))) {

            response.sendRedirect("/admin/dashboard");

        }

        // SI ES USUARIO NORMAL
        else {

            response.sendRedirect("/dashboard");
        }
    }
}
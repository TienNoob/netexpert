package com.backend.netexpert.config;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

public class IgnoreAuthHeaderFilter extends OncePerRequestFilter {

    private final String[] publicEndpoints;

    public IgnoreAuthHeaderFilter(String[] publicEndpoints) {
        this.publicEndpoints = publicEndpoints;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        // Kiểm tra nếu request thuộc PUBLIC_ENPOINTS
        boolean isPublicEndpoint = Arrays.stream(publicEndpoints).anyMatch(requestURI::startsWith);

        if (isPublicEndpoint) {
            // Loại bỏ header Authorization
            HttpServletRequest wrappedRequest = new HttpServletRequestWrapper(request) {
                @Override
                public String getHeader(String name) {
                    if ("Authorization".equalsIgnoreCase(name)) {
                        return null; // Xóa header Authorization
                    }
                    return super.getHeader(name);
                }
            };
            filterChain.doFilter(wrappedRequest, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}

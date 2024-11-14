package com.lexmedd.backend.iam.infrastructure.tokens.jwt;

import org.springframework.security.core.Authentication;

import com.lexmedd.backend.iam.application.internal.outboundservices.tokens.TokenService;

import jakarta.servlet.http.HttpServletRequest;

public interface BearerTokenService extends TokenService {

    /**
     * This method is responsible for extracting the JWT token from the HTTP
     * request.
     * 
     * @param token the HTTP request
     * @return String the JWT token
     */
    String getBearerTokenFrom(HttpServletRequest token);

    /**
     * This method is responsible for generating a JWT token from an authentication
     * object.
     * 
     * @param authentication the authentication object
     * @return String the JWT token
     * @see Authentication
     */
    String generateToken(Authentication authentication);
}

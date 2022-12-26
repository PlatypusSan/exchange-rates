package com.ecbrates.exchangeapi.controllers;

import com.ecbrates.exchangeapi.dto.AuthRequest;
import com.ecbrates.exchangeapi.dto.AuthResponse;
import com.ecbrates.exchangeapi.exceptions.UserUnauthenticated;
import com.ecbrates.exchangeapi.services.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthController {
    AuthService authService;

    @PostMapping("/sign-in")
    public AuthResponse auth(@RequestBody AuthRequest request) throws UserUnauthenticated {
        return new AuthResponse(authService.authorizeUserWithPassword(request));
    }
}

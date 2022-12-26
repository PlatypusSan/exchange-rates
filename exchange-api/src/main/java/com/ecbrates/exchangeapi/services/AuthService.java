package com.ecbrates.exchangeapi.services;

import com.ecbrates.exchangeapi.dto.AuthRequest;
import com.ecbrates.exchangeapi.exceptions.UserUnauthenticated;
import com.ecbrates.exchangeapi.models.User;
import com.ecbrates.exchangeapi.security.JwtProvider;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthService {

    UserService userService;
    JwtProvider jwtProvider;
    PasswordEncoder passwordEncoder;

    public String authorizeUserWithPassword(AuthRequest request) throws UserUnauthenticated {
        User user = userService.findByLogin(request.getLogin()).orElseThrow(() ->
                new UserUnauthenticated("Cannot authenticate user " + request.getLogin()));
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            //twoAuthService.requestCode(user.getPhone());
            return jwtProvider.generateAccessToken(user.getLogin());
        }
        throw new UserUnauthenticated("Cannot authenticate user " + request.getLogin());
    }

    /*public String validateCode(TwoAuthRequest request) throws UserUnauthenticated {
        User user = twoAuthService.validateCode(request.getCode())
                .orElseThrow(() -> new UserUnauthenticated("Cannot authenticate user: two-factor authentication failed"));
        return jwtProvider.generateAccessToken(user.getLogin());
    }*/
}

package com.ecbrates.exchangeapi.security;

import com.ecbrates.exchangeapi.services.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

/*import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;*/
import java.io.IOException;

@Component
public class JwtAuthFilter extends JwtFilterAbstract {

    public JwtAuthFilter(JwtProvider jwtProvider, CustomUserDetailsService customUserDetailsService) {
        super(jwtProvider, customUserDetailsService);
    }

    /*@Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }*/

    protected UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(CustomUserDetails customUserDetails) {
        return new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, jakarta.servlet.ServletException {
        super.doFilterInternal(servletRequest, TokenType.ACCESS_TOKEN);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
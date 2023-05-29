package com.paladin.paladin.configs;

import com.paladin.paladin.entities.Client;
import com.paladin.paladin.exceptions.ClientNotFound;
import com.paladin.paladin.repositories.ClientRepository;
import com.paladin.paladin.use_cases.auth.ValidateTokenUseCase;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    final UserDetailsService userDetailsService;
    final ValidateTokenUseCase validateTokenUseCase;
    final ClientRepository clientRepository;


    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        String headerToken = request.getHeader("Authorization");

        if (headerToken == null) {
            filterChain.doFilter(request, response);
            return;
        }

        if (!headerToken.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = headerToken.replace("Bearer ", "");
        String username = this.validateTokenUseCase.execute(token);

        Client client = this.clientRepository.findByUsername(username)
                .orElseThrow(() -> new ClientNotFound(null, null, null));

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                client,
                null,
                client.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

}


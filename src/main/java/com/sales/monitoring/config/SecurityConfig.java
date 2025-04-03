package com.sales.monitoring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Desabilita CSRF para o H2 Console e para as rotas de usuário
        http.csrf(csrf -> csrf
            .ignoringRequestMatchers(
                new AntPathRequestMatcher("/h2-console/**"),
                new AntPathRequestMatcher("/user/**"),
                new AntPathRequestMatcher("/auth/**")
            )
        );

        // Configura as permissões das requisições
        http.authorizeHttpRequests(auth -> auth
            .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
            .requestMatchers(new AntPathRequestMatcher("/user")).permitAll()
            .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
            .anyRequest().authenticated()
        );

        // Permite que o H2 Console seja exibido em frames
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        // Adiciona o filtro JWT antes do filtro padrão de autenticação
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Registra o AuthenticationManager para que ele possa ser injetado no AuthService
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
         return authenticationConfiguration.getAuthenticationManager();
    }
}

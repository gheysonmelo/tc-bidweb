package com.sales.monitoring.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.sales.monitoring.config.JwtUtil;
import com.sales.monitoring.dto.UserLoginDTO;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserDetailsService userDetailsService;

    public String authenticateAndGenerateToken(UserLoginDTO loginDTO) {
        // Tenta autenticar o usuário com as credenciais passadas
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
        );
        
        // Carrega os detalhes do usuário
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getUsername());
        
        // Gera e retorna o token JWT
        return jwtUtil.generateToken(userDetails);
    }
}

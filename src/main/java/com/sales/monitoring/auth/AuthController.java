package com.sales.monitoring.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sales.monitoring.dto.UserLoginDTO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO loginDTO) {
        
        String token = authService.authenticateAndGenerateToken(loginDTO);

        Map<String, String> response = new HashMap<>();

        response.put("token", token);
        
        return ResponseEntity.ok(response);
    }
}

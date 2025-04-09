package com.pdv.api.auth.controller;

import com.pdv.api.auth.model.DTO.LoginDTO;
import com.pdv.api.response.ApiResponse;
import com.pdv.api.sercurity.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO login) {
        // aqui você validaria no banco, por enquanto vamos simular
        if ("admin".equals(login.username()) && "123".equals(login.password())) {
            String token = jwtUtil.generateToken(login.username());
            return ResponseEntity.ok(new ApiResponse<>("Login com sucesso", token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse<>("Credenciais inválidas", null));
    }
}

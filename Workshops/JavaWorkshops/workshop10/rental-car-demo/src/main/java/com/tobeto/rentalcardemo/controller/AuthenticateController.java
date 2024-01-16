package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.services.abstracts.AuthenticateService;
import com.tobeto.rentalcardemo.services.dto.authenticate.requests.AuthenticationRequest;
import com.tobeto.rentalcardemo.services.dto.authenticate.requests.RegisterRequest;
import com.tobeto.rentalcardemo.services.dto.authenticate.responses.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticateController {

    private final AuthenticateService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
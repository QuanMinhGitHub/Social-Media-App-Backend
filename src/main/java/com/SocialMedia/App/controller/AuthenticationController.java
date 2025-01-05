package com.SocialMedia.App.controller;

import com.SocialMedia.App.request.SigninRequest;
import com.SocialMedia.App.response.AuthenticationResponse;
import com.SocialMedia.App.request.SignupRequest;
import com.SocialMedia.App.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/sign-up")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}

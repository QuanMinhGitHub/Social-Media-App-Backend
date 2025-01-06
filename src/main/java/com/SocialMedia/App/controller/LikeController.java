package com.SocialMedia.App.controller;

import com.SocialMedia.App.model.Like;
import com.SocialMedia.App.model.User;
import com.SocialMedia.App.repository.UserRepository;
import com.SocialMedia.App.service.JwtService;
import com.SocialMedia.App.service.LikeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/posts")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/like")
    public ResponseEntity<String> likePost(@RequestBody Like like, HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No valid token provided");
        }

        String token = authHeader.substring(7);
        String userEmail = jwtService.extractUsername(token);

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        likeService.likePost(user.getId(), like);
        return ResponseEntity.ok("Liked");
    }
}

package com.SocialMedia.App.controller;

import com.SocialMedia.App.model.Post;
import com.SocialMedia.App.model.User;
import com.SocialMedia.App.repository.UserRepository;
import com.SocialMedia.App.service.JwtService;
import com.SocialMedia.App.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/create-post")
    public ResponseEntity<String> createPost(@RequestBody Post post, HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No valid token provided");
        }

        String token = authHeader.substring(7);
        String userEmail = jwtService.extractUsername(token);

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        postService.createPost(user.getId(), post);

        return ResponseEntity.ok("Post created successfully");
    }

}

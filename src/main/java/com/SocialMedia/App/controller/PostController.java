package com.SocialMedia.App.controller;

import com.SocialMedia.App.model.Post;
import com.SocialMedia.App.repository.PostRepository;
import com.SocialMedia.App.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

//    @PutMapping
//
//    @DeleteMapping
}

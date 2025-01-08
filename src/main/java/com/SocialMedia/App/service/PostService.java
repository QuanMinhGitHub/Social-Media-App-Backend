package com.SocialMedia.App.service;

import com.SocialMedia.App.model.Post;
import com.SocialMedia.App.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void createPost(Integer userId, Post postRequest) {
        Post post = Post.builder()
                .content(postRequest.getContent())
                .image(postRequest.getImage())
                .userId(userId)
                .build();

        postRepository.save(post);
    }

    public Optional<Post> getPostById(Integer postId) {
        return postRepository.findById(postId);
    }

    public void updatePost(Integer postId, Post postRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));

        post.setContent(postRequest.getContent());
        post.setImage(postRequest.getImage());

        postRepository.save(post);
    }

    public void deletePost(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));

        postRepository.delete(post);
    }
}

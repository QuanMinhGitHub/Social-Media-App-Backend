package com.SocialMedia.App.service;

import com.SocialMedia.App.model.Post;
import com.SocialMedia.App.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

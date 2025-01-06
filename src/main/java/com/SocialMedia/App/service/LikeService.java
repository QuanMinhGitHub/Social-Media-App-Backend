package com.SocialMedia.App.service;

import com.SocialMedia.App.model.Like;
import com.SocialMedia.App.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public void likePost(Integer userId, Like likeRequest) {
        Like like = Like.builder()
                .userId(userId)
                .postId(likeRequest.getPostId())
                .build();

        likeRepository.save(like);
    }
}

package com.SocialMedia.App.service;

import com.SocialMedia.App.model.Comment;
import com.SocialMedia.App.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void commentOnPost(Integer userId, Comment commentRequest) {
        Comment comment = Comment.builder()
                .content(commentRequest.getContent())
                .postId(commentRequest.getPostId())
                .userId(userId)
                .build();

        commentRepository.save(comment);
    }
}

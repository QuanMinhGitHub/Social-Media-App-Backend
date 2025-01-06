package com.SocialMedia.App.repository;

import com.SocialMedia.App.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}

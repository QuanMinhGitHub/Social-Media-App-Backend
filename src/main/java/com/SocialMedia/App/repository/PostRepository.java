package com.SocialMedia.App.repository;

import com.SocialMedia.App.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}

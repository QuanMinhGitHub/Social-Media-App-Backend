package com.SocialMedia.App.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    private String content;
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

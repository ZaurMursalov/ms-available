package com.example.msavailable.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_category")
public class UserCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "user_id")
//    private Long userId;
//    @Column(name = "category_id")
//    private Long categoryId;

//    @Column(name = "comment_id")
//    private Long commentId;


    private boolean master;
    private boolean opinionated;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

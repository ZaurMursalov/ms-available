package com.example.msavailable.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "post_job")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostJobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "user_id")
//    private Long userId;
//
//    @Column(name = "category_id")
//    private Long categoryId;


    private String description;

    @Column(name = "employees_number")
    private Long employeesNumber;

    @Column(name = "created_at")
    private Date createdAt;



}

package com.example.msavailable.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCategoryRequest {
    private Long userId;
    private Long categoryId;
    private boolean isActive;
    private Long commentId;
    private boolean master;
    private boolean opinionated;
    private LocalDateTime createdAt;

}
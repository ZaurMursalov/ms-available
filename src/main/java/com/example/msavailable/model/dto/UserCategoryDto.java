package com.example.msavailable.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCategoryDto {
    private Long id;
    private Long userId;
    private Long categoryId;
    private boolean isActive;
    private Long commentId;
    private boolean master;
    private boolean opinionated;
    private LocalDateTime createdAt;

}

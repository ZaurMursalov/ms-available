package com.example.msavailable.mapper;

import com.example.msavailable.entity.UserEntity;
import com.example.msavailable.model.dto.UserDto;
import com.example.msavailable.model.request.UserRequest;


public class UserMapper {

    public static UserDto mapToUserDto(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .fin(entity.getFin())
                .companyName(entity.getCompanyName())
                .password(entity.getPassword())
                .phoneNumber(entity.getPhoneNumber())
                .voen(entity.getVoen())
                .build();


    }


    public static UserEntity mapToUserEntityPhysical(UserRequest request) {
        return UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .fin(request.getFin())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .build();


    }
    public static UserEntity mapToUserEntityCompany(UserRequest request) {
        return UserEntity.builder()
                .companyName(request.getCompanyName())
                .voen(request.getVoen())
                .phoneNumber(request.getPhoneNumber())
                .build();


    }


}

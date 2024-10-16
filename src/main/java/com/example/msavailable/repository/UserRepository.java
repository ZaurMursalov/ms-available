package com.example.msavailable.repository;

import com.example.msavailable.entity.UserEntity;
import com.example.msavailable.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

Optional<UserEntity>findByPhoneNumber(String phoneNumber);
}

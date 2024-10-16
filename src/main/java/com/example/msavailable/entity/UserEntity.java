package com.example.msavailable.entity;

import com.example.msavailable.model.dto.RoleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String fin;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String voen;

    @Column(name = "company_name")
    private String companyName;

    private String email;


}

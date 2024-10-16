package com.example.msavailable.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
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

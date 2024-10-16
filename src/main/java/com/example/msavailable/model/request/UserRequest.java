package com.example.msavailable.model.request;

import com.example.msavailable.model.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String name;
    private String surname;
    private String fin;
    private String password;
    private String phoneNumber;
    private String voen;
    private String companyName;
    private String email;
    private RoleDto roleDto;

}

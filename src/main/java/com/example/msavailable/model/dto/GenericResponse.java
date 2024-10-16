package com.example.msavailable.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GenericResponse <T>{

    private String error;
    private T data;

}

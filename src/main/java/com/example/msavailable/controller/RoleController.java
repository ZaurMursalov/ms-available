package com.example.msavailable.controller;

import com.example.msavailable.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/roles")
public class RoleController {
    private final RoleService roleService;
}

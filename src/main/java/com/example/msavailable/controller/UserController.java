package com.example.msavailable.controller;

import com.example.msavailable.model.request.UserRequest;
import com.example.msavailable.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity registerController(@RequestBody UserRequest request){
       return userService.register(request);
    }

    @PutMapping("/{id}/password")
    public ResponseEntity updatePasswordController(@PathVariable Long id,@RequestParam String password){
       return userService.updatePassword(id, password);
    }
}

package com.quizza.api.controller;

import com.quizza.api.ex.AlreadyExistsException;
import com.quizza.api.ex.UserNotFoundException;
import com.quizza.api.request.SignInRequest;
import com.quizza.api.request.SignUpRequest;
import com.quizza.api.service.AuthService;
import com.quizza.api.util.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {


    private AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity login(@RequestBody SignInRequest body) {

        try {
            Result<String> result = authService.signin(body.getEmail(), body.getPassword());
            return ResponseEntity.ok(result);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(new Result<>(false, e.getMessage(), "User not found"));
        }

    }

    @PostMapping("/sign-up")
    public ResponseEntity register(@RequestBody SignUpRequest body)  {
        try {
            Result<String> result = authService.signup(body.getEmail(), body.getPassword(), body.getName(), body.getSurname(), body.getUsername());
            return ResponseEntity.ok(result);
        } catch ( AlreadyExistsException e) {
            return ResponseEntity.badRequest().body(new Result<>(false, "error", "User already exists"));
        }


    }

}
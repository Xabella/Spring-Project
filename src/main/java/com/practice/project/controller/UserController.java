package com.practice.project.controller;

import com.practice.project.configuration.JwtUtils;
import com.practice.project.configuration.UserDetailsImpl;
import com.practice.project.dto.LoginRequestDto;
import com.practice.project.model.User;
import com.practice.project.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.practice.project.dto.LoginResponse;

import java.util.UUID;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserDetailsServiceImpl userService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping(path = "register")
    public ResponseEntity<?> saveUser(@RequestBody User userModel) {
        try {
            userService.saveUser(userModel);
            return ResponseEntity.ok(userService);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(path = "login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        LoginResponse login = new LoginResponse();

        login.setEmail(userDetails.getEmail());
        login.setUsername(userDetails.getUsername());
        login.setToken(jwt);

        return ResponseEntity.ok(login);
    }

    @GetMapping(path = "user")
    public ResponseEntity<?> getUser() {
        try {
            return ResponseEntity.ok(userService.getUser());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<?> deleteUser(@RequestParam(value = "userId") long userId) {
        try {

            userService.delete(userId);
            return ResponseEntity.ok("Employee Deleted Successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(path = "edit")
    public ResponseEntity<?> editUser(@RequestBody User userModel) {
        try {

            userService.editUser(userModel);
            return ResponseEntity.ok(userModel);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

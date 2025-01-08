package com.example.demo.controller;

import com.example.demo.dto.CreateUserRequest;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "CRUD operations for users")
public class UserController {
    private final UserService userService;

    @GetMapping
    @Operation(summary = "Get all users")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved users list")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved user")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new user")
    @ApiResponse(responseCode = "201", description = "User successfully created")
    public UserDto createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update existing user")
    @ApiResponse(responseCode = "200", description = "User successfully updated")
    public UserDto updateUser(@PathVariable Long id, @RequestBody CreateUserRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete user")
    @ApiResponse(responseCode = "204", description = "User successfully deleted")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
} 
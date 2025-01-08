package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@Tag(name = "Hello Controller", description = "Simple hello world endpoint")
public class HelloController {

    @Operation(summary = "Get hello message", description = "Returns a simple hello world message")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved hello message"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }
} 
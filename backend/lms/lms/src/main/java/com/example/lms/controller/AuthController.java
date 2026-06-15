package com.example.lms.controller;

import com.example.lms.dto.LoginRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="http://localhost:5173/")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO dto) {
    
	   if("admin".equals(dto.getUsername()) && "admin".equals(dto.getPassword()))   {
            return "JWT_TOKEN";
        }

        return "Invalid Credentials";
    }
}
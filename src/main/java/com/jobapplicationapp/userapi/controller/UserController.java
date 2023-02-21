package com.jobapplicationapp.userapi.controller;

import com.jobapplicationapp.userapi.dto.UserRequest;
import com.jobapplicationapp.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api/user/")
public class UserController {

    private final UserService userService;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean register(@RequestBody UserRequest request) {
        Boolean result = this.userService.register(request);
        return result;
    }

    @PostMapping("login")
    public void login(@RequestBody UserRequest request) {

    }
}

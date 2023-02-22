package com.jobapplicationapp.userapi.controller;

import com.jobapplicationapp.userapi.dto.UserRequest;
import com.jobapplicationapp.userapi.dto.UserResponse;
import com.jobapplicationapp.userapi.exception.UserNotFoundException;
import com.jobapplicationapp.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean register(@RequestBody UserRequest request) {
        Boolean result = this.userService.register(request);
        return result;
    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse login(@RequestBody UserRequest request) throws UserNotFoundException {
        return this.userService.login(request);
    }
}

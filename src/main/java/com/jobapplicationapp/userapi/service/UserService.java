package com.jobapplicationapp.userapi.service;

import com.jobapplicationapp.userapi.dto.UserRequest;
import com.jobapplicationapp.userapi.dto.UserResponse;
import com.jobapplicationapp.userapi.model.User;
import com.jobapplicationapp.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean register(UserRequest request) {
        Boolean alreadyExist = this.findEmail(request.getEmail());

        if (alreadyExist) {
            return false;
        } else {
            this.userRepository.save(User.builder()
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .build());
            return true;
        }
    }

    public boolean findEmail(String email) {
        List<User> users = this.userRepository.findByEmail(email);
        return users.size() > 0;
    }

    public UserResponse login(UserRequest request) {
        User user = this.userRepository.findFirstByEmail(request.getEmail());
        return UserResponse.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}

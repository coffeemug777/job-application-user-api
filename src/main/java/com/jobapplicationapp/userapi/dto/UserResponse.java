package com.jobapplicationapp.userapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
    private String email;
    private String password;
}

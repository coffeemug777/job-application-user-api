package com.jobapplicationapp.userapi.dto;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserRequest {
    @Id
    private String email;
    private String password;
}

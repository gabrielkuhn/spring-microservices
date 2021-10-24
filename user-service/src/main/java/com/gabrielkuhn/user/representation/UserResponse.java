package com.gabrielkuhn.user.representation;

import com.gabrielkuhn.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private User user;
    private Department department;
}

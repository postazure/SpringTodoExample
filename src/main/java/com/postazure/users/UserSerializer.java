package com.postazure.users;

import com.postazure.users.requests.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserSerializer {
    public List<UserResponse> serialize(Iterable<User> users) {
        return StreamSupport.stream(users.spliterator(), false)
                .map(this::serialize)
                .collect(Collectors.toList());
    }

    public UserResponse serialize(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .createdAt(user.getCreatedAt())
                .build();
    }
}

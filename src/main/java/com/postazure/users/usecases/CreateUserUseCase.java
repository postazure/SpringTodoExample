package com.postazure.users.usecases;

import com.postazure.ZonedDateTimeFactory;
import com.postazure.users.User;
import com.postazure.users.UserRepository;
import com.postazure.users.requests.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {
    UserRepository repository;

    @Autowired
    public CreateUserUseCase(UserRepository repository, ZonedDateTimeFactory zonedDateTimeFactory) {
        this.repository = repository;
    }

    public User create(UserCreateRequest request) {

        return repository.save(translateRequestToModel(request));
    }

    private User translateRequestToModel(UserCreateRequest request) {
        return User.builder()
                .username(request.getUsername())
                .build();
    }
}

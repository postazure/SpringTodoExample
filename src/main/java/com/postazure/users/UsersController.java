package com.postazure.users;

import com.postazure.users.requests.UserCreateRequest;
import com.postazure.users.requests.UserResponse;
import com.postazure.users.usecases.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/users")
@SuppressWarnings("unused")
public class UsersController {

    final private UserRepository repository;
    final private UserSerializer serializer;
    final private CreateUserUseCase createUserUseCase;

    @Autowired
    public UsersController(UserRepository repository, UserSerializer serializer, CreateUserUseCase createUserUseCase) {
        this.repository = repository;
        this.serializer = serializer;
        this.createUserUseCase = createUserUseCase;
    }

    @RequestMapping(method = GET)
    public List<UserResponse> index(){
        Iterable<User> users = repository.findAll();
        return serializer.serialize(users);
    }

    @RequestMapping(method = POST)
    public UserResponse create(@RequestBody UserCreateRequest request) {
        User user = createUserUseCase.create(request);
        return serializer.serialize(user);
    }
}

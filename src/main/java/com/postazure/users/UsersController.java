package com.postazure.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/users")
@SuppressWarnings("unused")
public class UsersController {

    final private UserRepository repository;
    final private UserSerializer serializer;

    @Autowired
    public UsersController(UserRepository repository, UserSerializer serializer) {
        this.repository = repository;
        this.serializer = serializer;
    }

    @RequestMapping(method = GET)
    public List<UserResponse> index(){
        Iterable<User> users = repository.findAll();
        List<UserResponse> serialize = serializer.serialize(users);
        return serialize;
    }

}

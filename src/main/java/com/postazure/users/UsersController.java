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

    private UserSerializer serializer;
    private UserService service;

    @Autowired
    public UsersController(UserService service, UserSerializer serializer) {
        this.serializer = serializer;
        this.service = service;
    }

    @RequestMapping(method = GET)
    public List<UserResponse> index(){
        Iterable<User> users = service.findAll();
        List<UserResponse> serialize = serializer.serialize(users);
        return serialize;
    }

}

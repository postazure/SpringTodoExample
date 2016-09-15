package com.postazure.users;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import resources.Fixtures;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

public class UsersControllerTest {

    private UsersController subject;

    @Mock
    private UserRepository repository;

    @Mock
    private UserSerializer serializer;

    @Before
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        subject = new UsersController(repository, serializer);
    }


    @Test
    public void index_shouldReturnAListOfUserResponses() throws Exception {
        User user = Fixtures.User().build();
        List<User> users = Collections.singletonList(user);
        doReturn(users).when(repository).findAll();

        UserResponse userResponse = Fixtures.UserResponse().build();
        doReturn(Collections.singletonList(userResponse)).when(serializer).serialize(users);

        List<UserResponse> response = subject.index();
        assertThat(response.get(0)).isEqualToComparingFieldByField(user);
    }
}
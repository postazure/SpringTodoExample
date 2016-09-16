package com.postazure.users;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import resources.Fixtures;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class UsersControllerTest {

    private UsersController subject;

    @Mock
    private UserRepository repository;

    @Mock
    private UserSerializer serializer;

    @Mock
    private CreateUserUseCase createUserUseCase;

    @Before
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        subject = new UsersController(repository, serializer, createUserUseCase);
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

    @Test
    public void create_shouldCreateANewUser() throws Exception {
        UserCreateRequest request = Fixtures.UserRequest().build();

        subject.create(request);

        verify(createUserUseCase).create(request);
    }

    @Test
    public void create_shouldReturnTheNewlyCreatedUser() throws Exception {
        UserCreateRequest request = Fixtures.UserRequest()
                .username("created")
                .build();
        UserResponse createdUser = Fixtures.UserResponse()
                .username(request.getUsername())
                .build();

        doReturn(createdUser).when(serializer).serialize(any(User.class));

        UserResponse userResponse = subject.create(request);

        assertThat(userResponse).isEqualToComparingFieldByField(createdUser);
    }
}
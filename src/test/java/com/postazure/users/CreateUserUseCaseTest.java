package com.postazure.users;

import com.postazure.ZonedDateTimeFactory;
import com.postazure.users.requests.UserCreateRequest;
import com.postazure.users.usecases.CreateUserUseCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import resources.Fixtures;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class CreateUserUseCaseTest {
    public static final ZonedDateTime NOW = ZonedDateTime.now();
    
    CreateUserUseCase subject;

    @Mock
    UserRepository repository;

    @Mock
    ZonedDateTimeFactory zonedDateTimeFactory;
    
    @Before
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);

        doReturn(NOW).when(zonedDateTimeFactory).now();

        subject = new CreateUserUseCase(repository, zonedDateTimeFactory);
    }

    @Test
    public void create_shouldCreateANewUser() throws Exception {
        UserCreateRequest request = Fixtures.UserRequest().username("username").build();

        User expectedUser = Fixtures.User().username(request.getUsername()).build();
        doReturn(expectedUser).when(repository).save(any(User.class));

        User createdUser = subject.create(request);

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(repository).save(argumentCaptor.capture());


        assertThat(request.getUsername()).isEqualTo(argumentCaptor.getValue().getUsername());
        assertThat(createdUser).isEqualToComparingFieldByField(expectedUser);
    }

}
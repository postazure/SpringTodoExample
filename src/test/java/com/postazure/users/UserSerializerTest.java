package com.postazure.users;

import com.postazure.users.requests.UserResponse;
import org.junit.Test;
import resources.Fixtures;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class UserSerializerTest {
    UserSerializer subject = new UserSerializer();
    ZonedDateTime now = ZonedDateTime.now();

    @Test
    public void serialize_shouldReturnAResponseObject() throws Exception {
        User user = Fixtures.User().build();

        UserResponse actual = subject.serialize(user);

        assertThat(actual).isEqualToComparingFieldByField(user);
    }

    @Test
    public void serialize_shouldReturnAListOfResponseObjects() throws Exception {
        User user1 = Fixtures.User().build();
        User user2 = Fixtures.User().id(2L).username("user2").createdAt(now.plusDays(2)).build();
        List<User> users = Arrays.asList(user1, user2);

        List<UserResponse> actual = subject.serialize(users);

        assertThat(actual.get(0)).isEqualToComparingFieldByField(user1);
        assertThat(actual.get(1)).isEqualToComparingFieldByField(user2);
    }
}
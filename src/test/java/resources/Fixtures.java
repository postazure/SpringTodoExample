package resources;

import com.postazure.users.User;
import com.postazure.users.UserResponse;

import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Fixtures {
    public static ZonedDateTime ZONE_DATE_TIME = ZonedDateTime.of(1945, Month.DECEMBER.getValue(), 7, 5, 23, 1, 0, ZoneId.of("America/Los_Angeles"));

    public static User.UserBuilder User() {
        return User.builder()
                .id(123L)
                .createdAt(ZONE_DATE_TIME)
                .username("Fixture Username");
    }

    public static UserResponse.UserResponseBuilder UserResponse() {
        return UserResponse.builder()
                .id(123L)
                .createdAt(ZONE_DATE_TIME)
                .username("Fixture Username");
    }
}

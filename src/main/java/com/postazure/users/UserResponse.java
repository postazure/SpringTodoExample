package com.postazure.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Builder
@Data
public class UserResponse implements Serializable {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("createdAt")
    private ZonedDateTime createdAt;
}

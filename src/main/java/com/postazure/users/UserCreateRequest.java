package com.postazure.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserCreateRequest {

    @JsonProperty("username")
    private String username;
}

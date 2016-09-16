package com.postazure.users;

import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class ZonedDateTimeFactory {
    public ZonedDateTime now() {
        return ZonedDateTime.now();
    }
}

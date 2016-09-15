package com.postazure.users;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Getter
@Builder
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "username")
    private String username;
}

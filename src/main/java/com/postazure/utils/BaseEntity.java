package com.postazure.utils;

import lombok.Getter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;
}

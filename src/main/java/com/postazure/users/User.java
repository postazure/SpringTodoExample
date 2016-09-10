package com.postazure.users;

import com.postazure.utils.BaseEntity;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "username")
    private String username;

}

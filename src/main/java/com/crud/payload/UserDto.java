package com.crud.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long userId;
    private String userName;
    private String userEmail;
    private String password;
}

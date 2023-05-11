package com.crud.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private String token;
    private String tokenType ="Bearer";

    public ResponseDto(String token) {
        this.token = token;
    }
}

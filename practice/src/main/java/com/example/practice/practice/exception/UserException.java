package com.example.practice.practice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserException extends RuntimeException {

    private HttpStatus errorCode;
    private  String errorMessage;

}

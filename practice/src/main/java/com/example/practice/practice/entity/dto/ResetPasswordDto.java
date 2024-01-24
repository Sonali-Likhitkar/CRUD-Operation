package com.example.practice.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordDto {

    private long employeeId;
    private  String oldPassword;
    private  String newPassword;

}

package com.example.practice.practice.entity.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.*;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequestDto {

    @Email
    @Column(name="email")
    private String email;
    private String password;
}

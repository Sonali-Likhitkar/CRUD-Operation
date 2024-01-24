package com.example.practice.practice.entity.dto;

import com.example.practice.practice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDTO {

    private String course;
    private String duration;
}

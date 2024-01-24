package com.example.practice.practice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String name;
    private String email;
    private String password;
    private String age;
    private AddressDTO addressDTO;
    private List<CertificateDTO> certificateDTO;
}

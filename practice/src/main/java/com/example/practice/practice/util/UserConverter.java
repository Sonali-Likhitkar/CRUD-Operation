package com.example.practice.practice.util;

import com.example.practice.practice.entity.User;
import com.example.practice.practice.entity.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserConverter {

//
//    private final AddressConverter  addressConverter;
//
//    private final CertificateConverter certificateConverter;
//
//    public UserConverter(AddressConverter addressConverter,CertificateConverter certificateConverter){
//        this.addressConverter =addressConverter;
//        this.certificateConverter=certificateConverter;
//    }
//
//    public User dtoToEntity(UserDTO userDTO) {
//        User user =new User();
//        user.setName(userDTO.getName());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(userDTO.getPassword());
//        user.setAge(userDTO.getAge());
//        if(userDTO.getAddressDTO()!= null){
//            user.setAddress(addressConverter.dtoToEntity(userDTO.getAddressDTO()));
//        }
//        if(userDTO.getCertificateDTO()!= null){
//            user.setCertificates(userDTO.getCertificateDTO().stream().map(certificateDTO -> certificateConverter.dtoToEntity(certificateDTO)).collect(Collectors.toList()));
//        }
//        return user;
//    }
//
//    public UserDTO entityToDto(User user){
//        UserDTO userDTO=new UserDTO();
//        userDTO.setName(user.getName());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setAge(user.getAge());
//        if(user.getAddress() != null){
//            userDTO.setAddressDTO(addressConverter.entityToDto(user.getAddress()));
//        }
//        if(user.getCertificates() != null){
//            userDTO.setCertificateDTO(user.getCertificates().stream().map(certificate -> certificateConverter.entityToDto(certificate)).collect(Collectors.toList()));
//        }
//        return userDTO;
//    }


//
//    public UserDTO listToDto(List<User> user) {
//     List <UserDTO> userToDtoList= new ArrayList<>();
//     user.stream().forEach(u->{userToDtoList.add(entityToDto(u));
//     });
//        return (UserDTO) userToDtoList;
//    }

    }
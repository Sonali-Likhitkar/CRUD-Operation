package com.example.practice.practice.util;

import com.example.practice.practice.entity.Address;
import com.example.practice.practice.entity.dto.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    public Address dtoToEntity(AddressDTO addressDTO){
        Address address= new Address();
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        return address;
    }

    public  AddressDTO entityToDto(Address address){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        return addressDTO;

    }
}

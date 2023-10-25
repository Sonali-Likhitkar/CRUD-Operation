package com.example.practice.practice.util;

import com.example.practice.practice.dto.EmployeeDto;
import com.example.practice.practice.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {


    //    public User convertToEntity(UserDTO userDto) {
//        User user = new User();
//        user.setUserId(userDto.getUserId());
//        user.setFirstName(userDto.getFirstName());
//        user.setLastName(userDto.getLastName());
//        user.setGender(userDto.getGender());
//        user.setDob(userDto.getDob());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setPhone(userDto.getPhone());
//        user.setDeleted(userDto.isDeleted());
//        user.setCreatedBy(userDto.getCreatedBy());
//        user.setUpdatedBy(userDto.getUpdatedBy());
//        user.setCreatedAt(userDto.getCreatedAt());
//        user.setUpdatedAt(userDto.getUpdatedAt());
//
//
//        return user;
//    }
    public static Employee convertToEntity(EmployeeDto empRequestDto) {
        Employee employee = new Employee();
        employee.setEmployeeId(empRequestDto.getEmployeeId());
        employee.setJobTitle(empRequestDto.getJobTitle());
        employee.setEmail(empRequestDto.getEmail());
        employee.setPassword(empRequestDto.getPassword());
        employee.setFirstName(empRequestDto.getFirstName());
        employee.setLastName(empRequestDto.getLastName());
        employee.setAge(empRequestDto.getAge());
        employee.setDob(empRequestDto.getDob());
//        employee.setCertificate(empRequestDto.getCertificate());
        return employee;
    }

    //    public static UserSettingsRequestDTO convertToDto(UserSettings userSettings) {
//        UserSettingsRequestDTO userSettingsRequestDTO = new UserSettingsRequestDTO();
//        userSettingsRequestDTO.setUserSettingsId(userSettings.getUserSettingsId());
//        userSettingsRequestDTO.setUserId(userSettings.getUserId());
//        userSettingsRequestDTO.setLanguage(userSettings.getLanguage());
//        userSettingsRequestDTO.setTimezone(userSettings.getTimezone());
//        userSettingsRequestDTO.setReceiveNotifications(userSettings.getReceiveNotifications());
//        userSettingsRequestDTO.setCreatedAt(userSettings.getCreatedAt());
//        userSettingsRequestDTO.setUpdatedAt(userSettings.getUpdatedAt());
//        return userSettingsRequestDTO;
//    }

    public static EmployeeDto convertToDto(Employee employee) {
        EmployeeDto empRequestDto = new EmployeeDto();
        empRequestDto.setEmployeeId(employee.getEmployeeId());
        empRequestDto.setJobTitle(employee.getJobTitle());
        empRequestDto.setEmail(employee.getEmail());
        empRequestDto.setPassword(employee.getPassword());
        empRequestDto.setFirstName(employee.getFirstName());
        empRequestDto.setLastName(employee.getLastName());
        empRequestDto.setAge(employee.getAge());
        empRequestDto.setDob(employee.getDob());
//        empRequestDto.setCertificate(employee.getCertificate());
        return empRequestDto;

    }


}

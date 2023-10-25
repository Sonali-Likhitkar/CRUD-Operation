package com.example.practice.practice.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Certificate {

    @Id
    private  int certificateId ;
    private String  Course;
    private String duration;
}

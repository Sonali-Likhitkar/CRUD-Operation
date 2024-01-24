package com.example.practice.practice.util;

import com.example.practice.practice.entity.Certificate;
import com.example.practice.practice.entity.dto.CertificateDTO;
import org.springframework.stereotype.Component;

@Component
public class CertificateConverter {

    public Certificate dtoToEntity(CertificateDTO certificateDTO){
        Certificate certificate = new Certificate();
        certificate.setCourse(certificateDTO.getCourse());
        certificate.setDuration(certificateDTO.getDuration());
        return certificate;
    }
 public  CertificateDTO entityToDto(Certificate certificate){
        CertificateDTO certificateDTO=new CertificateDTO();
        certificateDTO.setCourse(certificate.getCourse());
        certificateDTO.setDuration(certificate.getDuration());
        return certificateDTO;
 }

}

package com.nhnacademy.Resident.Dto.resident;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ResidentRequest {
    private Long residentSerialNumber;
    private String name;
    private String residentRegistrationNumber;
    private String genderCode;
    private LocalDateTime birthDate;
    private String birthPlaceCode;
    private String registrationBaseAddress;
    private LocalDateTime deathDate;
    private String deathPlaceCode;
    private String deathPlaceAddress;
}

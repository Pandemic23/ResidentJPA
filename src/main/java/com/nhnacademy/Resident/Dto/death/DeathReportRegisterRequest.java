package com.nhnacademy.Resident.Dto.death;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class DeathReportRegisterRequest {
    private Long targetSerialNumber;
    private LocalDateTime birthDeathReportDate;
    private String deathReportQualificationsCode;
    private String emailAddress;
    private String phoneNumber;
    private LocalDateTime deathDate;
    private String deathPlaceCode;
    private String deathPlaceAddress;
}

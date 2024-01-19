package com.nhnacademy.Resident.Dto.birth;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BirthReportEditRequest {
    private LocalDateTime birthDeathReportDate;
    private String birthReportQualificationsCode;
    private String emailAddress;
    private String phoneNumber;
    private LocalDateTime birthDate;
    private String birthPlaceCode;
}

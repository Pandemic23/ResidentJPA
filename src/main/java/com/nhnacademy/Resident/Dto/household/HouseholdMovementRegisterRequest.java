package com.nhnacademy.Resident.Dto.household;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class HouseholdMovementRegisterRequest {
    private LocalDateTime houseMovementReportDate;
    private String houseMovementAddress;
    private String lastAddressYn;
}

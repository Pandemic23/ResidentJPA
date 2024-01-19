package com.nhnacademy.Resident.Dto.household;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class HouseholdRegisterRequest {
    private Long householdResidentSerialNumber;
    private Long householdSerialNumber;
    private String householdCompositionReasonCode;
    private String currentHouseMovementAddress;
    private LocalDateTime reportDate;
    private String lastAddressYn;
    private String householdRelationshipCode;
    private String householdCompositionChangeReasonCode;
}

package com.nhnacademy.Resident.Dto.household;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class HouseholdMemberRegisterRequest {
    private Long householdResidentSerialNumber;
    private String householdCompositionReasonCode;
    private LocalDateTime reportDate;
    private String householdRelationshipCode;
    private String householdCompositionChangeReasonCode;
}
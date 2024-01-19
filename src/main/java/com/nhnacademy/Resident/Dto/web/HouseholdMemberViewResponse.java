package com.nhnacademy.Resident.Dto.web;

import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class HouseholdMemberViewResponse {
    private String householdRelationshipCode;
    private String name;
    private String residentRegistrationNumber;
    private LocalDateTime reportDate;
    private String householdCompositionChangeReasonCode;

    @QueryProjection
    public HouseholdMemberViewResponse(String householdRelationshipCode, String name, String residentRegistrationNumber,
                                       LocalDateTime reportDate, String householdCompositionChangeReasonCode) {
        this.householdRelationshipCode = householdRelationshipCode;
        this.name = name;
        this.residentRegistrationNumber = residentRegistrationNumber;
        this.reportDate = reportDate;
        this.householdCompositionChangeReasonCode = householdCompositionChangeReasonCode;
    }
}

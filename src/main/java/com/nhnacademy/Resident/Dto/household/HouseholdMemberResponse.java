package com.nhnacademy.Resident.Dto.household;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhnacademy.Resident.entity.HouseholdCompositionResident;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseholdMemberResponse {
    private Long householdResidentSerialNumber;
    private Long householdSerialNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private LocalDateTime reportDate;
    private String householdRelationshipCode;
    private String householdCompositionChangeReasonCode;

    public static HouseholdMemberResponse of(HouseholdCompositionResident householdComposition) {
        return HouseholdMemberResponse.builder()
                .householdResidentSerialNumber(householdComposition.getResident().getResidentSerialNumber())
                .householdSerialNumber(householdComposition.getHousehold().getHouseholdSerialNumber())
                .reportDate(householdComposition.getReportDate())
                .householdRelationshipCode(householdComposition.getHouseholdRelationshipCode())
                .householdCompositionChangeReasonCode(householdComposition.getHouseholdCompositionChangeReasonCode())
                .build();
    }
}

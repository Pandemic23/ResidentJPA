package com.nhnacademy.Resident.Dto.household;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhnacademy.Resident.entity.Household;
import com.nhnacademy.Resident.entity.HouseholdCompositionResident;
import com.nhnacademy.Resident.entity.HouseholdMovementAddress;
import com.nhnacademy.Resident.entity.Resident;
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
public class HouseholdResponse {

    private Long householdResidentSerialNumber; // 세대주 주민 번호

    private Long householdSerialNumber; // 세대 번호

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime householdCompositionDate; // 세대 구성 일자
    private String householdCompositionReasonCode; // 세대 구성 사유 코드
    private String currentHouseMovementAddress; // 현재 전입 주소

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime reportDate; // 전입 신고 일자, 세대 구성 주민 신고 일자
    private String lastAddressYn; // 최종 주소 여부

    private String householdRelationshipCode; // 세대주 관계 코드
    private String householdCompositionChangeReasonCode; // 세대 구성 변동 사유 코드

    public static HouseholdResponse of(Resident resident, Household household,
                                       HouseholdMovementAddress movementAddress,
                                       HouseholdCompositionResident compositionResident) {
        return HouseholdResponse.builder()
                .householdResidentSerialNumber(resident.getResidentSerialNumber())
                .householdSerialNumber(household.getHouseholdSerialNumber())
                .householdCompositionDate(household.getHouseholdCompositionDate())
                .householdCompositionReasonCode(household.getHouseholdCompositionReasonCode())
                .currentHouseMovementAddress(household.getCurrentHouseMovementAddress())
                .reportDate(household.getHouseholdCompositionDate())
                .lastAddressYn(movementAddress.getLastAddressYn())
                .householdRelationshipCode(compositionResident.getHouseholdRelationshipCode())
                .householdCompositionChangeReasonCode(compositionResident.getHouseholdCompositionChangeReasonCode())
                .build();
    }
}

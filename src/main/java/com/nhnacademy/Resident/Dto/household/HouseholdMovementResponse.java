package com.nhnacademy.Resident.Dto.household;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhnacademy.Resident.entity.HouseholdMovementAddress;
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
public class HouseholdMovementResponse {

    private Long householdSerialNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private LocalDateTime houseMovementReportDate;
    private String houseMovementAddress;
    private String lastAddressYn;

    public static HouseholdMovementResponse of(HouseholdMovementAddress movementAddress) {
        return HouseholdMovementResponse.builder()
                .householdSerialNumber(movementAddress.getPk().getHouseholdSerialNumber())
                .houseMovementReportDate(movementAddress.getPk().getHouseMovementReportDate())
                .houseMovementAddress(movementAddress.getHouseMovementAddress())
                .lastAddressYn(movementAddress.getLastAddressYn())
                .build();
    }
}

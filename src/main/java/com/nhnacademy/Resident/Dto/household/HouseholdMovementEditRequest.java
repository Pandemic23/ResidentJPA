package com.nhnacademy.Resident.Dto.household;

import lombok.Data;

@Data
public class HouseholdMovementEditRequest {
    private String houseMovementAddress;
    private String lastAddressYn;
}

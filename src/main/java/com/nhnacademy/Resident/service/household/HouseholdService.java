package com.nhnacademy.Resident.service.household;

import com.nhnacademy.Resident.Dto.household.HouseholdMemberRegisterRequest;
import com.nhnacademy.Resident.Dto.household.HouseholdMemberResponse;
import com.nhnacademy.Resident.Dto.household.HouseholdMovementEditRequest;
import com.nhnacademy.Resident.Dto.household.HouseholdMovementRegisterRequest;
import com.nhnacademy.Resident.Dto.household.HouseholdMovementResponse;
import com.nhnacademy.Resident.Dto.household.HouseholdRegisterRequest;
import com.nhnacademy.Resident.Dto.household.HouseholdResponse;
import com.nhnacademy.Resident.Dto.web.HouseholdMemberViewResponse;
import com.nhnacademy.Resident.entity.HouseholdMovementAddress;
import java.time.LocalDateTime;
import java.util.List;

public interface HouseholdService {
    HouseholdResponse registerHousehold(HouseholdRegisterRequest request);

    void deleteHousehold(Long householdSerialNumber);

    HouseholdMemberResponse registerHouseholdMember(Long householdSerialNumber, HouseholdMemberRegisterRequest request);

    void deleteHouseholdMember(Long householdSerialNumber, Long householdResidentSerialNumber);

    HouseholdMovementResponse registerHouseholdMovement(Long householdSerialNumber,
                                                        HouseholdMovementRegisterRequest request);

    HouseholdMovementResponse editHouseholdMovement(Long householdSerialNumber, LocalDateTime reportDate,
                                                    HouseholdMovementEditRequest request);

    void deleteHouseholdMovement(LocalDateTime reportDate, Long householdSerialNumber);

    List<HouseholdMemberViewResponse> getHouseholdMembers(Long householdSerialNumber);

    Long getSerialNumber(Long serialNumber);

    List<HouseholdMovementAddress> getMovementAddresses(Long householdSerialNumber);
}
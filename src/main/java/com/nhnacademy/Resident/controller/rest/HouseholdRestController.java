package com.nhnacademy.Resident.controller.rest;

import com.nhnacademy.Resident.Dto.household.HouseholdMemberRegisterRequest;
import com.nhnacademy.Resident.Dto.household.HouseholdMemberResponse;
import com.nhnacademy.Resident.Dto.household.HouseholdMovementEditRequest;
import com.nhnacademy.Resident.Dto.household.HouseholdMovementRegisterRequest;
import com.nhnacademy.Resident.Dto.household.HouseholdMovementResponse;
import com.nhnacademy.Resident.Dto.household.HouseholdRegisterRequest;
import com.nhnacademy.Resident.Dto.household.HouseholdResponse;
import com.nhnacademy.Resident.service.household.HouseholdService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/household")
@RequiredArgsConstructor
public class HouseholdRestController {

    private final HouseholdService householdService;

    @PostMapping
    public ResponseEntity<HouseholdResponse> householdRegister(@RequestBody HouseholdRegisterRequest request) {
        HouseholdResponse response = householdService.registerHousehold(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{householdSerialNumber}")
    public ResponseEntity<String> householdDelete(@PathVariable Long householdSerialNumber) {
        householdService.deleteHousehold(householdSerialNumber);
        return ResponseEntity.ok("household delete success");
    }

    @PostMapping("/{householdSerialNumber}/member")
    public ResponseEntity<HouseholdMemberResponse> householdMemberRegister(@PathVariable Long householdSerialNumber,
                                                                           @RequestBody
                                                                           HouseholdMemberRegisterRequest request) {
        HouseholdMemberResponse response = householdService.registerHouseholdMember(householdSerialNumber, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{householdSerialNumber}/member/{householdResidentSerialNumber}")
    public ResponseEntity<String> householdMemberDelete(
            @PathVariable("householdSerialNumber") Long householdSerialNumber,
            @PathVariable("householdResidentSerialNumber") Long householdResidentSerialNumber) {
        householdService.deleteHouseholdMember(householdSerialNumber, householdResidentSerialNumber);
        return ResponseEntity.ok("household member delete success");
    }

    @PostMapping("/{householdSerialNumber}/movement")
    public ResponseEntity<HouseholdMovementResponse> householdMovementRegister(@PathVariable Long householdSerialNumber,
                                                                               @RequestBody
                                                                               HouseholdMovementRegisterRequest request) {
        HouseholdMovementResponse response = householdService.registerHouseholdMovement(householdSerialNumber, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{householdSerialNumber}/movement/{reportDate}")
    public ResponseEntity<HouseholdMovementResponse> householdMovementEdit(
            @PathVariable("householdSerialNumber") Long householdSerialNumber,
            @PathVariable("reportDate") String reportDate,
            @RequestBody HouseholdMovementEditRequest request) {
        LocalDateTime date = convertLocalDateTime(reportDate);
        HouseholdMovementResponse response =
                householdService.editHouseholdMovement(householdSerialNumber, date, request);
        return ResponseEntity.ok(response);
    }

    private LocalDateTime convertLocalDateTime(String reportDate) {
        LocalDate localDate = LocalDate.parse(reportDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return LocalDateTime.of(localDate, LocalTime.MIN);
    }

    @DeleteMapping("/{householdSerialNumber}/movement/{reportDate}")
    public ResponseEntity<String> householdMovementDelete(
            @PathVariable("householdSerialNumber") Long householdSerialNumber,
            @PathVariable("reportDate") String reportDate) {
        LocalDateTime date = convertLocalDateTime(reportDate);
        householdService.deleteHouseholdMovement(date, householdSerialNumber);
        return ResponseEntity.ok("household movement address delete success");
    }
}

package com.nhnacademy.Resident.controller.rest;

import com.nhnacademy.Resident.Dto.birth.BirthReportEditRequest;
import com.nhnacademy.Resident.Dto.birth.BirthReportRegisterRequest;
import com.nhnacademy.Resident.Dto.birth.BirthReportResponse;
import com.nhnacademy.Resident.Dto.death.DeathReportEditRequest;
import com.nhnacademy.Resident.Dto.death.DeathReportRegisterRequest;
import com.nhnacademy.Resident.Dto.death.DeathReportResponse;
import com.nhnacademy.Resident.Dto.relationship.RelationshipEditRequest;
import com.nhnacademy.Resident.Dto.relationship.RelationshipRegisterRequest;
import com.nhnacademy.Resident.Dto.relationship.RelationshipResponse;
import com.nhnacademy.Resident.Dto.resident.ResidentRequest;
import com.nhnacademy.Resident.Dto.resident.ResidentResponse;
import com.nhnacademy.Resident.service.birthdeathreport.BirthDeathReportService;
import com.nhnacademy.Resident.service.relationship.RelationshipService;
import com.nhnacademy.Resident.service.resident.ResidentService;
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
@RequestMapping("/residents")
@RequiredArgsConstructor
public class ResidentRestController {

    private final ResidentService residentService;
    private final RelationshipService relationshipService;
    private final BirthDeathReportService birthDeathReportService;

    @PostMapping
    public ResponseEntity<ResidentResponse> registerResident(@RequestBody ResidentRequest request) {
        ResidentResponse response = residentService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{serialNumber}")
    public ResponseEntity<ResidentResponse> editResident(@PathVariable Long serialNumber,
                                                         @RequestBody ResidentRequest request) {
        ResidentResponse response = residentService.edit(request, serialNumber);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{serialNumber}/relationship")
    public ResponseEntity<RelationshipResponse> registerRelationship(@PathVariable Long serialNumber,
                                                                     @RequestBody RelationshipRegisterRequest request) {
        RelationshipResponse response = relationshipService.register(serialNumber, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{serialNumber}/relationship/{familySerialNumber}")
    public ResponseEntity<RelationshipResponse> editRelationship(@PathVariable("serialNumber") Long serialNumber,
                                                                 @PathVariable("familySerialNumber")
                                                                 Long familySerialNumber,
                                                                 @RequestBody RelationshipEditRequest request) {
        RelationshipResponse response = relationshipService.edit(serialNumber, familySerialNumber, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{serialNumber}/relationship/{familySerialNumber}")
    public ResponseEntity<String> deleteRelationship(@PathVariable("serialNumber") Long serialNumber,
                                                     @PathVariable("familySerialNumber") Long familySerialNumber) {
        relationshipService.delete(serialNumber, familySerialNumber);
        return ResponseEntity.ok("delete success");
    }

    @PostMapping("/{serialNumber}/birth")
    public ResponseEntity<BirthReportResponse> registerBirthReport(@PathVariable Long serialNumber,
                                                                   @RequestBody BirthReportRegisterRequest request) {
        BirthReportResponse response = birthDeathReportService.birthRegister(serialNumber, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{serialNumber}/birth/{targetSerialNumber}")
    public ResponseEntity<BirthReportResponse> editBirthReport(@PathVariable("serialNumber") Long serialNumber,
                                                               @PathVariable("targetSerialNumber")
                                                               Long targetSerialNumber,
                                                               @RequestBody BirthReportEditRequest request) {
        BirthReportResponse response = birthDeathReportService.birthEdit(serialNumber, targetSerialNumber, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{serialNumber}/birth/{targetSerialNumber}")
    public ResponseEntity<String> deleteBirthReport(@PathVariable("serialNumber") Long serialNumber,
                                                    @PathVariable("targetSerialNumber") Long targetSerialNumber) {
        birthDeathReportService.birthDelete(serialNumber, targetSerialNumber);
        return ResponseEntity.ok("delete success");
    }

    @PostMapping("/{serialNumber}/death")
    public ResponseEntity<DeathReportResponse> registerDeathReport(@PathVariable Long serialNumber,
                                                                   @RequestBody DeathReportRegisterRequest request) {
        DeathReportResponse response = birthDeathReportService.deathRegister(serialNumber, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{serialNumber}/death/{targetSerialNumber}")
    public ResponseEntity<DeathReportResponse> editDeathReport(@PathVariable("serialNumber") Long serialNumber,
                                                               @PathVariable("targetSerialNumber")
                                                               Long targetSerialNumber,
                                                               @RequestBody DeathReportEditRequest request) {
        DeathReportResponse response = birthDeathReportService.deathEdit(serialNumber, targetSerialNumber, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{serialNumber}/death/{targetSerialNumber}")
    public ResponseEntity<String> deleteDeathReport(@PathVariable("serialNumber") Long serialNumber,
                                                    @PathVariable("targetSerialNumber") Long targetSerialNumber) {
        birthDeathReportService.deathDelete(serialNumber, targetSerialNumber);
        return ResponseEntity.ok("delete success");
    }
}

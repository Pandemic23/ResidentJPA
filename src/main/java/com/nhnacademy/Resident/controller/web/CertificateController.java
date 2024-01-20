package com.nhnacademy.Resident.controller.web;


import com.nhnacademy.Resident.Dto.resident.ResidentResponse;
import com.nhnacademy.Resident.Dto.web.BirthCertificateResponse;
import com.nhnacademy.Resident.Dto.web.CertificateIssueResponse;
import com.nhnacademy.Resident.Dto.web.DeathCertificateResponse;
import com.nhnacademy.Resident.Dto.web.FamilyResponse;
import com.nhnacademy.Resident.Dto.web.HouseholdMemberViewResponse;
import com.nhnacademy.Resident.entity.HouseholdMovementAddress;
import com.nhnacademy.Resident.service.birthdeathreport.BirthDeathReportService;
import com.nhnacademy.Resident.service.household.HouseholdService;
import com.nhnacademy.Resident.service.issue.CertificateIssueService;
import com.nhnacademy.Resident.service.relationship.RelationshipService;
import com.nhnacademy.Resident.service.resident.ResidentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/certificate")
@RequiredArgsConstructor
public class CertificateController {

    private final ResidentService residentService;
    private final RelationshipService relationshipService;
    private final BirthDeathReportService birthDeathReportService;
    private final HouseholdService householdService;
    private final CertificateIssueService certificateIssueService;


    @GetMapping("/{serialNumber}/family")
    public String familyCertification(@PathVariable Long serialNumber, ModelMap modelMap) {
        ResidentResponse baseResident = residentService.findBySerialNumber(serialNumber);
        List<FamilyResponse> members = relationshipService.getFamilyMembers(serialNumber);

        modelMap.addAttribute("resident", baseResident);
        modelMap.addAttribute("members", members);

        return "familyCertificate";
    }

    @GetMapping("/{serialNumber}/household")
    public String householdCertification(@PathVariable Long serialNumber, ModelMap modelMap) {
        ResidentResponse baseResident = residentService.findBySerialNumber(serialNumber);
        Long householdSerialNumber = householdService.getSerialNumber(serialNumber);
        List<HouseholdMovementAddress> addresses = householdService.getMovementAddresses(householdSerialNumber);
        List<HouseholdMemberViewResponse> members = householdService.getHouseholdMembers(householdSerialNumber);

        modelMap.addAttribute("resident", baseResident);
        modelMap.addAttribute("addresses", addresses);
        modelMap.addAttribute("members", members);

        return "householdCertificate";
    }

    @GetMapping("/{serialNumber}/birth")
    public String birthCertification(@PathVariable Long serialNumber, ModelMap modelMap) {
        BirthCertificateResponse certificate = birthDeathReportService.getBirthCertification(serialNumber);
        modelMap.addAttribute("certificate", certificate);
        return "birthCertificate";
    }

    @GetMapping("/{serialNumber}/death")
    public String deathCertification(@PathVariable Long serialNumber, ModelMap modelMap) {
        DeathCertificateResponse certificate = birthDeathReportService.getDeathCertification(serialNumber);
        modelMap.addAttribute("certificate", certificate);
        return "deathCertificate";
    }

    @GetMapping("/{serialNumber}/issue")
    public String certificationIssueList(@PathVariable Long serialNumber, @PageableDefault(size = 1) Pageable pageable,
                                         ModelMap modelMap) {
        Page<CertificateIssueResponse> responsePage = certificateIssueService.findAll(serialNumber, pageable);
        List<CertificateIssueResponse> certificates = responsePage.getContent();
        int totalPages = responsePage.getTotalPages();

        modelMap.addAttribute("certificates", certificates);
        modelMap.addAttribute("totalPages", totalPages);
        return "certificateIssue";
    }

}

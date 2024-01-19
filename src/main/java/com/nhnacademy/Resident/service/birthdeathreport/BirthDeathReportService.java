package com.nhnacademy.Resident.service.birthdeathreport;

import com.nhnacademy.Resident.Dto.birth.BirthReportEditRequest;
import com.nhnacademy.Resident.Dto.birth.BirthReportRegisterRequest;
import com.nhnacademy.Resident.Dto.birth.BirthReportResponse;
import com.nhnacademy.Resident.Dto.death.DeathReportEditRequest;
import com.nhnacademy.Resident.Dto.death.DeathReportRegisterRequest;
import com.nhnacademy.Resident.Dto.death.DeathReportResponse;
import com.nhnacademy.Resident.Dto.web.BirthCertificateResponse;
import com.nhnacademy.Resident.Dto.web.DeathCertificateResponse;

public interface BirthDeathReportService {
    BirthCertificateResponse getBirthCertification(Long serialNumber);

    BirthReportResponse birthRegister(Long serialNumber, BirthReportRegisterRequest request);

    BirthReportResponse birthEdit(Long serialNumber, Long targetSerialNumber, BirthReportEditRequest request);

    void birthDelete(Long serialNumber, Long targetSerialNumber);

    DeathCertificateResponse getDeathCertification(Long serialNumber);

    DeathReportResponse deathRegister(Long serialNumber, DeathReportRegisterRequest request);

    DeathReportResponse deathEdit(Long serialNumber, Long targetSerialNumber, DeathReportEditRequest request);

    void deathDelete(Long serialNumber, Long targetSerialNumber);

}

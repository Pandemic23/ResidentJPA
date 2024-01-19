package com.nhnacademy.Resident.repository.birthdeath;

import com.nhnacademy.Resident.Dto.web.BirthCertificateResponse;
import com.nhnacademy.Resident.Dto.web.DeathCertificateResponse;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BirthDeathReportResidentCustom {
    BirthCertificateResponse getBirthCertification(Long targetSerialNumber);

    DeathCertificateResponse getDeathCertification(Long targetSerialNumber);
}

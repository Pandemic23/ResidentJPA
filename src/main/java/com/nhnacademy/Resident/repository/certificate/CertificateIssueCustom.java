package com.nhnacademy.Resident.repository.certificate;

import com.nhnacademy.Resident.Dto.web.CertificateIssueResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CertificateIssueCustom {
    Page<CertificateIssueResponse> findAllByResident(Long residentSerialNumber, Pageable pageable);
}

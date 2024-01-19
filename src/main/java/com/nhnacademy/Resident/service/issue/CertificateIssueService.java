package com.nhnacademy.Resident.service.issue;

import com.nhnacademy.Resident.Dto.web.CertificateIssueResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CertificateIssueService {
    Page<CertificateIssueResponse> findAll(Long residentSerialNumber, Pageable pageable);
}

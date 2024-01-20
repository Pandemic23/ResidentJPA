package com.nhnacademy.Resident.service.issue;

import com.nhnacademy.Resident.Dto.web.CertificateIssueResponse;
import com.nhnacademy.Resident.repository.certificate.CertificateIssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CertificateIssueServiceImpl implements CertificateIssueService {

    private final CertificateIssueRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Page<CertificateIssueResponse> findAll(Long residentSerialNumber, Pageable pageable) {
        return repository.findAllByResident(residentSerialNumber, pageable);
    }
}

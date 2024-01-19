package com.nhnacademy.Resident.repository.certificate;

import com.nhnacademy.Resident.entity.CertificateIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateIssueRepository extends JpaRepository<CertificateIssue, Long>, CertificateIssueCustom {
}

package com.nhnacademy.Resident.repository.certificate;

import com.nhnacademy.Resident.Dto.web.CertificateIssueResponse;
import com.nhnacademy.Resident.Dto.web.QCertificateIssueResponse;
import com.nhnacademy.Resident.entity.CertificateIssue;
import com.nhnacademy.Resident.entity.QCertificateIssue;
import com.nhnacademy.Resident.entity.QResident;
import com.nhnacademy.Resident.exception.CertificateIssueNotFoundException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CertificateIssueRepositoryImpl extends QuerydslRepositorySupport implements CertificateIssueCustom {
    public CertificateIssueRepositoryImpl() {
        super(CertificateIssue.class);
    }

    @Override
    public Page<CertificateIssueResponse> findAllByResident(Long residentSerialNumber, Pageable pageable) {
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;
        QResident resident = QResident.resident;

        List<CertificateIssueResponse> certificates = from(certificateIssue)
                .select(new QCertificateIssueResponse(
                        resident.residentSerialNumber,
                        certificateIssue.certificateConfirmationNumber,
                        resident.name,
                        resident.residentRegistrationNumber,
                        certificateIssue.certificateTypeCode,
                        certificateIssue.certificateIssueDate
                ))
                .innerJoin(certificateIssue.resident, resident)
                .where(certificateIssue.resident.residentSerialNumber.eq(residentSerialNumber))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        if (certificates.isEmpty()) {
            throw new CertificateIssueNotFoundException("대상 주민의 증명서 발급내역이 없습니다.");
        }

        Long totalCount = from(certificateIssue)
                .select(certificateIssue.count())
                .fetchOne();

        return new PageImpl<>(certificates, pageable, totalCount);
    }
}

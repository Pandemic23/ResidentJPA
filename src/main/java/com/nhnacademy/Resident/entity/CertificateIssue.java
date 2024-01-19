package com.nhnacademy.Resident.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "certificate_issue")
public class CertificateIssue {

    @Id
    @Column(name = "certificate_confirmation_number")
    private Long certificateConfirmationNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @Column(name = "certificate_type_code", nullable = false, length = 20)
    private String certificateTypeCode;

    @Column(name = "certificate_issue_date", nullable = false)
    private LocalDateTime certificateIssueDate;

    @Builder
    public CertificateIssue(Long certificateConfirmationNumber, Resident resident, String certificateTypeCode,
                            LocalDateTime certificateIssueDate) {
        this.certificateConfirmationNumber = certificateConfirmationNumber;
        this.resident = resident;
        this.certificateTypeCode = certificateTypeCode;
        this.certificateIssueDate = certificateIssueDate;
    }
}

package com.nhnacademy.Resident.Dto.death;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhnacademy.Resident.entity.BirthDeathReportResident;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeathReportResponse {
    private Long targetSerialNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime birthDeathReportDate;
    private String deathReportQualificationsCode;
    private String emailAddress;
    private String phoneNumber;

    public static DeathReportResponse of(BirthDeathReportResident entity) {
        return DeathReportResponse.builder()
                .targetSerialNumber(entity.getTargetResident().getResidentSerialNumber())
                .birthDeathReportDate(entity.getBirthDeathReportDate())
                .deathReportQualificationsCode(entity.getDeathReportQualificationsCode())
                .emailAddress(entity.getEmailAddress())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }
}

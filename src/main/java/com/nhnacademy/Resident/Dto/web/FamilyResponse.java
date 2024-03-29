package com.nhnacademy.Resident.Dto.web;

import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class FamilyResponse {
    private String familyRelationshipCode;
    private String name;
    private LocalDateTime birthDate;
    private String residentRegistrationNumber;
    private String genderCode;

    @QueryProjection
    public FamilyResponse(String familyRelationshipCode, String name, LocalDateTime birthDate,
                          String residentRegistrationNumber, String genderCode) {
        this.familyRelationshipCode = familyRelationshipCode;
        this.name = name;
        this.birthDate = birthDate;
        this.residentRegistrationNumber = residentRegistrationNumber;
        this.genderCode = genderCode;
    }
}

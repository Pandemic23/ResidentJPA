package com.nhnacademy.Resident.repository.family;

import com.nhnacademy.Resident.Dto.web.FamilyResponse;
import com.nhnacademy.Resident.Dto.web.QFamilyResponse;
import com.nhnacademy.Resident.entity.FamilyRelationship;
import com.nhnacademy.Resident.entity.QFamilyRelationship;
import com.nhnacademy.Resident.entity.QResident;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class FamilyRelationshipRepositoryImpl extends QuerydslRepositorySupport implements FamilyRelationshipCustom {
    public FamilyRelationshipRepositoryImpl() {
        super(FamilyRelationship.class);
    }

    @Override
    public List<FamilyResponse> findMyFamily(Long residentSerialNumber) {
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;
        QResident familyResident = QResident.resident;

        return from(familyRelationship)
                .select(new QFamilyResponse(
                        familyRelationship.familyRelationshipCode,
                        familyResident.name,
                        familyResident.birthDate,
                        familyResident.residentRegistrationNumber,
                        familyResident.genderCode
                ))
                .innerJoin(familyRelationship.familyResident, familyResident)
                .where(familyRelationship.pk.baseResidentSerialNumber.eq(residentSerialNumber))
                .fetch();
    }
}

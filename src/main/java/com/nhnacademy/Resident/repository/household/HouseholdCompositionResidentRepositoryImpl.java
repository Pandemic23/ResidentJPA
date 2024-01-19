package com.nhnacademy.Resident.repository.household;


import com.nhnacademy.Resident.Dto.web.HouseholdMemberViewResponse;
import com.nhnacademy.Resident.Dto.web.QHouseholdMemberViewResponse;
import com.nhnacademy.Resident.entity.HouseholdCompositionResident;
import com.nhnacademy.Resident.entity.QHouseholdCompositionResident;
import com.nhnacademy.Resident.entity.QResident;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;


public class HouseholdCompositionResidentRepositoryImpl extends QuerydslRepositorySupport
        implements HouseholdCompositionResidentCustom {
    public HouseholdCompositionResidentRepositoryImpl() {
        super(HouseholdCompositionResident.class);
    }

    @Override
    public Long findByResidentSerialNumber(Long serialNumber) {
        QHouseholdCompositionResident hcr = QHouseholdCompositionResident.householdCompositionResident;

        return from(hcr)
                .select(hcr.pk.householdSerialNumber)
                .where(hcr.pk.residentSerialNumber.eq(serialNumber))
                .fetchOne();
    }

    @Override
    public List<HouseholdMemberViewResponse> getAllMembers(Long householdSerialNumber) {
        QHouseholdCompositionResident hcr = QHouseholdCompositionResident.householdCompositionResident;
        QResident resident = QResident.resident;

        return from(hcr)
                .select(new QHouseholdMemberViewResponse(
                        hcr.householdRelationshipCode,
                        resident.name,
                        resident.residentRegistrationNumber,
                        hcr.reportDate,
                        hcr.householdCompositionChangeReasonCode
                ))
                .innerJoin(hcr.resident, resident)
                .where(hcr.pk.householdSerialNumber.eq(householdSerialNumber))
                .fetch();
    }
}

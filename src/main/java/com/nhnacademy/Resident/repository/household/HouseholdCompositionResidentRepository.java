package com.nhnacademy.Resident.repository.household;

import com.nhnacademy.Resident.entity.HouseholdCompositionResident;
import com.nhnacademy.Resident.entity.HouseholdCompositionResident.Pk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface HouseholdCompositionResidentRepository
        extends JpaRepository<HouseholdCompositionResident, Pk>, HouseholdCompositionResidentCustom {
    @Transactional
    @Modifying
    @Query("delete from HouseholdCompositionResident hcr where hcr.pk.householdSerialNumber = :householdSerialNumber")
    void deleteAllByHouseholdSerialNumber(@Param("householdSerialNumber") Long householdSerialNumber);
}

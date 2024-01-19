package com.nhnacademy.Resident.repository.household;

import static com.nhnacademy.Resident.entity.HouseholdMovementAddress.*;

import com.nhnacademy.Resident.entity.HouseholdMovementAddress;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress, Pk> {
    @Transactional
    @Modifying
    @Query("delete from HouseholdMovementAddress hma where hma.pk.householdSerialNumber = :householdSerialNumber")
    void deleteAllByHouseholdSerialNumber(@Param("householdSerialNumber") Long householdSerialNumber);

    @Transactional
    @Modifying
    @Query("delete from HouseholdMovementAddress hma where hma.pk.houseMovementReportDate = :reportDate")
    void deleteByReportDate(@Param("reportDate") LocalDateTime reportDate);

    List<HouseholdMovementAddress> findAllByHousehold_HouseholdSerialNumberOrderByPk_HouseMovementReportDateDesc(
            Long householdSerialNumber);
}

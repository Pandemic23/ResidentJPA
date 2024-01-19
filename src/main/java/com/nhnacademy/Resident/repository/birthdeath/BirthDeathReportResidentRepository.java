package com.nhnacademy.Resident.repository.birthdeath;


import com.nhnacademy.Resident.entity.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthDeathReportResidentRepository
        extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk>, BirthDeathReportResidentCustom {
}

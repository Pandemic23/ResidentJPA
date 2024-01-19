package com.nhnacademy.Resident.repository.resident;

import com.nhnacademy.Resident.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
}

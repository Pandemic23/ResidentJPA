package com.nhnacademy.Resident.service.resident;

import com.nhnacademy.Resident.Dto.resident.ResidentRequest;
import com.nhnacademy.Resident.Dto.resident.ResidentResponse;
import com.nhnacademy.Resident.entity.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResidentService {
    Page<Resident> getResidents(Pageable pageable);

    ResidentResponse register(ResidentRequest request);

    ResidentResponse edit(ResidentRequest request, Long serialNumber);

    ResidentResponse findBySerialNumber(Long serialNumber);
}

package com.nhnacademy.Resident.service.resident;

import com.nhnacademy.Resident.Dto.resident.ResidentRequest;
import com.nhnacademy.Resident.Dto.resident.ResidentResponse;
import com.nhnacademy.Resident.entity.Resident;
import com.nhnacademy.Resident.exception.ResidentNotFoundException;
import com.nhnacademy.Resident.repository.resident.ResidentRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Page<Resident> getResidents(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ResidentResponse register(ResidentRequest request) {
        Resident resident = Resident.builder()
                .residentSerialNumber(request.getResidentSerialNumber())
                .name(request.getName())
                .residentRegistrationNumber(request.getResidentRegistrationNumber())
                .genderCode(request.getGenderCode())
                .birthDate(request.getBirthDate())
                .birthPlaceCode(request.getBirthPlaceCode())
                .registrationBaseAddress(request.getRegistrationBaseAddress())
                .deathDate(request.getDeathDate())
                .deathPlaceCode(request.getDeathPlaceCode())
                .deathPlaceAddress(request.getDeathPlaceAddress())
                .build();

        repository.save(resident);

        return ResidentResponse.of(resident);
    }

    @Override
    public ResidentResponse edit(ResidentRequest request, Long serialNumber) {
        Resident resident = getResident(serialNumber);

        resident.setName(request.getName());
        resident.setResidentRegistrationNumber(request.getResidentRegistrationNumber());
        resident.setGenderCode(request.getGenderCode());
        resident.setBirthDate(request.getBirthDate());
        resident.setBirthPlaceCode(request.getBirthPlaceCode());
        resident.setRegistrationBaseAddress(request.getRegistrationBaseAddress());
        resident.setDeathDate(request.getDeathDate());
        resident.setDeathPlaceCode(request.getDeathPlaceCode());
        resident.setDeathPlaceAddress(request.getDeathPlaceAddress());

        repository.save(resident);

        return ResidentResponse.of(resident);
    }

    private Resident getResident(Long serialNumber) {
        Optional<Resident> optionalResident = repository.findById(serialNumber);
        if (optionalResident.isEmpty()) {
            throw new ResidentNotFoundException("해당하는 주민이 없습니다.");
        }
        return optionalResident.get();
    }

    @Transactional(readOnly = true)
    @Override
    public ResidentResponse findBySerialNumber(Long serialNumber) {
        Resident resident = getResident(serialNumber);
        return ResidentResponse.of(resident);
    }
}

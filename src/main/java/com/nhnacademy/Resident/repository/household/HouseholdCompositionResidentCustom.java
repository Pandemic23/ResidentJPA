package com.nhnacademy.Resident.repository.household;

import com.nhnacademy.Resident.Dto.web.HouseholdMemberViewResponse;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface HouseholdCompositionResidentCustom {
    Long findByResidentSerialNumber(Long serialNumber);

    List<HouseholdMemberViewResponse> getAllMembers(Long householdSerialNumber);
}

package com.nhnacademy.Resident.repository.family;

import com.nhnacademy.Resident.Dto.web.FamilyResponse;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FamilyRelationshipCustom {
    List<FamilyResponse> findMyFamily(Long residentSerialNumber);
}

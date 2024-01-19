package com.nhnacademy.Resident.service.relationship;

import com.nhnacademy.Resident.Dto.relationship.RelationshipEditRequest;
import com.nhnacademy.Resident.Dto.relationship.RelationshipRegisterRequest;
import com.nhnacademy.Resident.Dto.relationship.RelationshipResponse;
import com.nhnacademy.Resident.Dto.web.FamilyResponse;
import java.util.List;

public interface RelationshipService {
    List<FamilyResponse> getFamilyMembers(Long serialNumber);

    RelationshipResponse register(Long serialNumber, RelationshipRegisterRequest request);

    RelationshipResponse edit(Long serialNumber, Long familySerialNumber, RelationshipEditRequest request);

    void delete(Long serialNumber, Long familySerialNumber);
}

package com.nhnacademy.Resident.Dto.relationship;

import com.nhnacademy.Resident.entity.FamilyRelationship;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RelationshipResponse {
    private Long familySerialNumber;
    private String relationShip;

    public static RelationshipResponse of(FamilyRelationship relationship) {
        return RelationshipResponse.builder()
                .familySerialNumber(relationship.getPk().getFamilyResidentSerialNumber())
                .relationShip(relationship.getFamilyRelationshipCode())
                .build();
    }
}

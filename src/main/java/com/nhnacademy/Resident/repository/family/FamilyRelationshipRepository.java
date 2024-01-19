package com.nhnacademy.Resident.repository.family;

import static com.nhnacademy.Resident.entity.FamilyRelationship.*;

import com.nhnacademy.Resident.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, Pk>, FamilyRelationshipCustom {
}

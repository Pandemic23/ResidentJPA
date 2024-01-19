package com.nhnacademy.Resident.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "family_relationship")
@NoArgsConstructor
public class FamilyRelationship {

    @EmbeddedId
    private Pk pk;

    @Column(name = "family_relationship_code", nullable = false, length = 20)
    private String familyRelationshipCode;

    @MapsId("baseResidentSerialNumber")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_resident_serial_number")
    private Resident baseResident;

    @MapsId("familyResidentSerialNumber")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_resident_serial_number")
    private Resident familyResident;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "base_resident_serial_number")
        private Long baseResidentSerialNumber;

        @Column(name = "family_resident_serial_number")
        private Long familyResidentSerialNumber;
    }

    @Builder
    public FamilyRelationship(String familyRelationshipCode, Resident baseResident, Resident familyResident) {
        this.familyRelationshipCode = familyRelationshipCode;
        this.baseResident = baseResident;
        this.familyResident = familyResident;
        this.pk = new Pk(baseResident.getResidentSerialNumber(), familyResident.getResidentSerialNumber());
    }
}

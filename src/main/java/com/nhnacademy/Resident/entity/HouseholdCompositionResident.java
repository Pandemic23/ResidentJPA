package com.nhnacademy.Resident.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "household_composition_resident")
@NoArgsConstructor
public class HouseholdCompositionResident {

    @EmbeddedId
    private Pk pk;

    @Column(name = "report_date", nullable = false)
    private LocalDateTime reportDate;

    @Column(name = "household_relationship_code", nullable = false, length = 20)
    private String householdRelationshipCode;

    @Column(name = "household_composition_change_reason_code", nullable = false, length = 20)
    private String householdCompositionChangeReasonCode;

    @MapsId("householdSerialNumber")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @MapsId("residentSerialNumber")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "household_serial_number")
        private Long householdSerialNumber;

        @Column(name = "resident_serial_number")
        private Long residentSerialNumber;
    }

    @Builder
    public HouseholdCompositionResident(Pk pk, LocalDateTime reportDate,
                                        String householdRelationshipCode,
                                        String householdCompositionChangeReasonCode,
                                        Household household, Resident resident) {
        this.pk = pk;
        this.reportDate = reportDate;
        this.householdRelationshipCode = householdRelationshipCode;
        this.householdCompositionChangeReasonCode = householdCompositionChangeReasonCode;
        this.household = household;
        this.resident = resident;
    }
}

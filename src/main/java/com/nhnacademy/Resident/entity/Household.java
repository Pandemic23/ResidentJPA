package com.nhnacademy.Resident.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "household")
public class Household {

    @Id
    @Column(name = "household_serial_number")
    private Long householdSerialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "household_resident_serial_number")
    private Resident householdResident;

    @Column(name = "household_composition_date", nullable = false)
    private LocalDateTime householdCompositionDate;

    @Column(name = "household_composition_reason_code", nullable = false, length = 20)
    private String householdCompositionReasonCode;

    @Column(name = "current_house_movement_address", nullable = false, length = 500)
    private String currentHouseMovementAddress;

    @Builder
    public Household(Long householdSerialNumber, Resident householdResident,
                     LocalDateTime householdCompositionDate, String householdCompositionReasonCode,
                     String currentHouseMovementAddress) {
        this.householdSerialNumber = householdSerialNumber;
        this.householdResident = householdResident;
        this.householdCompositionDate = householdCompositionDate;
        this.householdCompositionReasonCode = householdCompositionReasonCode;
        this.currentHouseMovementAddress = currentHouseMovementAddress;
    }
}

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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "household_movement_address")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HouseholdMovementAddress {

    @EmbeddedId
    private Pk pk;

    @MapsId("householdSerialNumber")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @Column(name = "house_movement_address", nullable = false, length = 500)
    private String houseMovementAddress;

    @Column(name = "last_address_yn", nullable = false, length = 1)
    private String lastAddressYn;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "house_movement_report_date")
        private LocalDateTime houseMovementReportDate;

        @Column(name = "household_serial_number")
        private Long householdSerialNumber;
    }

    @Builder
    public HouseholdMovementAddress(Pk pk, Household household,
                                    String houseMovementAddress, String lastAddressYn) {
        this.pk = pk;
        this.household = household;
        this.houseMovementAddress = houseMovementAddress;
        this.lastAddressYn = lastAddressYn;
    }
}

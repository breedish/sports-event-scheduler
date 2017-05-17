package com.breedish.ses.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
public class Location extends BaseEntity {
    @NotNull
    @Column(nullable = false, unique = true)
    private String name;
    @Column(unique = true)
    private String phone;
    private Address address;
    @NotNull
    private LocationCoordinates coordinates;

    @Tolerate
    Location() {
    }

}

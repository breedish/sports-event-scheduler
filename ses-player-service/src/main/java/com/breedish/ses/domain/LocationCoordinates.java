package com.breedish.ses.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Embeddable
public class LocationCoordinates {
    @NotNull
    @Column(nullable = false)
    private Double latitude;
    @NotNull
    @Column(nullable = false)
    private Double longitude;

    @Tolerate
    LocationCoordinates() {
    }
}

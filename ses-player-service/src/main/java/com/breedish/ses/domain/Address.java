package com.breedish.ses.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Embeddable
public class Address {
    @NotNull
    private String street;
    @NotNull
    private String building;
    private String city;
    private String address;

    @Tolerate
    Address() {
    }
}

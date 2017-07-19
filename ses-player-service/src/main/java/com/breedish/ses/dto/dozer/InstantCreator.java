package com.breedish.ses.dto.dozer;

import io.craftsman.creator.Creator;

import java.time.Instant;

public class InstantCreator implements Creator<Instant> {

    @Override
    public Instant create(Object source) {
        Instant o = (Instant) source;
        return Instant.from(o);
    }
}

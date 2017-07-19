package com.breedish.ses.dto.dozer;

import io.craftsman.Jdk8CompatibilityConverter;

import java.time.Instant;

public class DozerCustomTypeConverter extends Jdk8CompatibilityConverter {

    private DozerCreatorFactory creatorFactory = new DozerCreatorFactory();

    @Override
    public Object convert(Object destination, Object source, Class<?> destinationClass, Class<?> sourceClass) {
        destination = super.convert(destination, source, destinationClass, sourceClass);
        if (destination == null) {
            if (destinationClass.isAssignableFrom(Instant.class) && sourceClass.isAssignableFrom(Instant.class)) {
                destination = creatorFactory.createInstantCreator().create(source);
            }
        }

        return destination;

    }
}

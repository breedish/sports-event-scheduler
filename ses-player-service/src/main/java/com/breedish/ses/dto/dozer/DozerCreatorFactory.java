package com.breedish.ses.dto.dozer;

import io.craftsman.creator.CreatorFactory;

public class DozerCreatorFactory extends CreatorFactory {

    private InstantCreator instantCreator;

    public InstantCreator createInstantCreator() {
        if (instantCreator == null) {
            instantCreator = new InstantCreator();
        }
        return instantCreator;
    }
}

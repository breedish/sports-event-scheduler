@GenericGenerator(name = "id_generator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
        @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "SES_SEQUENCE"),
        @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
        @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "10"),
        @Parameter(name = SequenceStyleGenerator.OPT_PARAM, value = "pooled-lo")
    }
)
package com.breedish.ses.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
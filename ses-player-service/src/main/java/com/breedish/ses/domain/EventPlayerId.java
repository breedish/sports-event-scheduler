package com.breedish.ses.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@Builder
public class EventPlayerId implements Serializable {

    private Long eventId;

    private Long playerId;

    @Tolerate
    EventPlayerId() {
    }
}

package com.breedish.ses.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Data
@Builder
@EqualsAndHashCode
@Entity
public class EventPlayer {

    @EmbeddedId
    private EventPlayerId id;

    @ManyToOne
    @MapsId("eventId")
    private Event event;

    @ManyToOne
    @MapsId("playerId")
    private Player player;

    private boolean optional;

    @Tolerate
    EventPlayer() {
    }

}

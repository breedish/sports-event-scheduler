package com.breedish.ses.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import java.time.Instant;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Immutable
public class EventPlay extends BaseEntity {

    private Instant closed;

    private Instant started;

    @Tolerate
    EventPlay() {
    }
}

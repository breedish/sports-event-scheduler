package com.breedish.ses.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
public class Event extends BaseEntity {
    @NotNull
    @Column(nullable = false, unique = true)
    private String name;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @NotNull
    @ManyToMany(cascade = CascadeType.PERSIST) @JoinTable(
        name = "event_play_admins",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> admins;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SportsType sportsType = SportsType.FOOTBALL;
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Collection<EventPlayer> players = new ArrayList<>();

    @Tolerate
    Event() {
    }
}

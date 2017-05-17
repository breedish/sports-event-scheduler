package com.breedish.ses.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
public class Player extends BaseEntity {
    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;
    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;
    @NotBlank
    private String firstName;
    private String lastName;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String phone;

    @Tolerate
    Player() {
    }
}

package com.breedish.ses.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerFullDto {
    Long id;
    String name;
    String email;
    String firstName;
    String lastName;
    String phone;
    Instant created;
    Instant updated;
    int version;
}

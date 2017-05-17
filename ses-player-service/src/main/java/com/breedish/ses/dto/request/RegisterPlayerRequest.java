package com.breedish.ses.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Builder
public class RegisterPlayerRequest {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @Length(min = 2, max = 15)
    private String firstName;
    private String lastName;
    @Length(min = 7, max = 15)
    private String phone;

    @Tolerate
    RegisterPlayerRequest() {
    }
}

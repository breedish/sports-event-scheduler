package com.breedish.ses.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDto {
    private String message;
    private Integer code;
}

package com.ms.User.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(
        @NotBlank String name,
        @NotBlank String email) {
}

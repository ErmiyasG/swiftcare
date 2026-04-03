package org.postwork.er.swiftcare.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateClinicRequest(
        @NotBlank(message = "Clinic name is required")
        String name
) {
}

package org.postwork.er.swiftcare.dto;

import jakarta.validation.constraints.NotNull;
import org.postwork.er.swiftcare.model.Operation;
import org.postwork.er.swiftcare.model.Severity;

public record UpdatePatientRequest(
        @NotNull Severity severity,
        @NotNull Operation operation
) {
}

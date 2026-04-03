package org.postwork.er.swiftcare.dto;

import java.util.UUID;

public record WaitTimeResponse(
        UUID clinicId,
        int estimatedMinutes
) {
}

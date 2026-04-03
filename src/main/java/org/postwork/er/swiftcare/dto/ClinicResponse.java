package org.postwork.er.swiftcare.dto;

import java.util.UUID;

public record ClinicResponse(
    UUID id,
    String name,
    int minorCount,
    int standardCount,
    int acuteCount
){

}

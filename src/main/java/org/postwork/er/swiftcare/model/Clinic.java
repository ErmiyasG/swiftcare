package org.postwork.er.swiftcare.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Clinic {
    private UUID id;
    private String name;
    private int minorCount;
    private int standardCount;
    private int acuteCount;
}

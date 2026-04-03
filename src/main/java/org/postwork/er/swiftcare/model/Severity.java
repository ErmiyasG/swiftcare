package org.postwork.er.swiftcare.model;

public enum Severity {
    MINOR(15),
    STANDARD(30),
    ACUTE(45);

    private final int minutes;

    Severity(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }
}

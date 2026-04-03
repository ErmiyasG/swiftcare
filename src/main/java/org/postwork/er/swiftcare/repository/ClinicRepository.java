package org.postwork.er.swiftcare.repository;

import org.postwork.er.swiftcare.model.Clinic;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ClinicRepository {

    private final Map<UUID, Clinic> clinics = new ConcurrentHashMap<>();

    public Clinic save(Clinic clinic) {
        clinics.put(clinic.getId(), clinic);
        return clinic;
    }

    public Optional<Clinic> findById(UUID id) {
        return Optional.ofNullable(clinics.get(id));
    }

    public Collection<Clinic> findAll() {
        return clinics.values();
    }
}

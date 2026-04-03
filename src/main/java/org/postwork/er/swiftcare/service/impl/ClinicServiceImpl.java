package org.postwork.er.swiftcare.service.impl;

import org.postwork.er.swiftcare.dto.ClinicResponse;
import org.postwork.er.swiftcare.dto.CreateClinicRequest;
import org.postwork.er.swiftcare.dto.UpdatePatientRequest;
import org.postwork.er.swiftcare.dto.WaitTimeResponse;
import org.postwork.er.swiftcare.exception.ResourceNotFoundException;
import org.postwork.er.swiftcare.model.Clinic;
import org.postwork.er.swiftcare.model.Operation;
import org.postwork.er.swiftcare.model.Severity;
import org.postwork.er.swiftcare.repository.ClinicRepository;
import org.postwork.er.swiftcare.service.ClinicService;

import java.util.UUID;

public class ClinicServiceImpl implements ClinicService {

    private ClinicRepository repository;

    @Override
    public ClinicResponse createClinic(CreateClinicRequest request) {
        Clinic clinic = new Clinic();
        clinic.setId(UUID.randomUUID());
        clinic.setName(request.name());
        clinic.setMinorCount(0);
        clinic.setStandardCount(0);
        clinic.setAcuteCount(0);

        repository.save(clinic);

        return mapToResponce(clinic);
    }

    @Override
    public ClinicResponse getClinic(UUID id) {
        Clinic clinic =  getClinicOrThrow(id);

        return mapToResponce(clinic);
    }

    @Override
    public WaitTimeResponse getWaitTime(UUID id) {
        Clinic clinic = getClinicOrThrow(id);
        int total = calculateWaitTime(clinic);

        return new WaitTimeResponse(id, total);
    }

    @Override
    public void updatePatientCount(UUID id, UpdatePatientRequest request) {
        Clinic clinic = getClinicOrThrow(id);

        int currentCount = switch (request.severity()) {
            case MINOR -> clinic.getMinorCount();
            case STANDARD -> clinic.getStandardCount();
            case ACUTE -> clinic.getAcuteCount();
        };

        if (request.operation() == Operation.DECREMENT && currentCount ==0) {
            throw new IllegalArgumentException("Patient count can not be zero");
        }

        switch (request.severity()) {
            case MINOR -> clinic.setMinorCount(
                    updateCount(clinic.getMinorCount(), request.operation())
            );
            case STANDARD -> clinic.setStandardCount(
                    updateCount(clinic.getStandardCount(), request.operation())
            );
            case ACUTE -> clinic.setAcuteCount(
                    updateCount(clinic.getAcuteCount(), request.operation())
            );
        }
    }



    private int updateCount(int current, Operation operation) {
        return operation == Operation.INCREMENR ? current + 1 : current -1;
    }

    private  int calculateWaitTime(Clinic clinic) {

        int waitTime = clinic.getMinorCount() * Severity.MINOR.getMinutes()
                + clinic.getStandardCount() * Severity.STANDARD.getMinutes()
            + clinic.getAcuteCount() * Severity.ACUTE.getMinutes();

        return waitTime;
    }

    private Clinic getClinicOrThrow(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clinic not Found"));
    }

    private ClinicResponse mapToResponce(Clinic clinic) {
        return  new ClinicResponse(
                clinic.getId(),
                clinic.getName(),
                clinic.getMinorCount(),
                clinic.getStandardCount(),
                clinic.getAcuteCount()
        );
    }
}

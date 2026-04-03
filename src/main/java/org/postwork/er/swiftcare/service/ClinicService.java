package org.postwork.er.swiftcare.service;

import org.postwork.er.swiftcare.dto.ClinicResponse;
import org.postwork.er.swiftcare.dto.CreateClinicRequest;
import org.postwork.er.swiftcare.dto.UpdatePatientRequest;
import org.postwork.er.swiftcare.dto.WaitTimeResponse;

import java.util.UUID;

public interface ClinicService {

    ClinicResponse createClinic(CreateClinicRequest request);

    ClinicResponse getClinic(UUID id);

    WaitTimeResponse getWaitTime(UUID id);

    void updatePatientCount(UUID id, UpdatePatientRequest request);
}

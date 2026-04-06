package org.postwork.er.swiftcare.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.postwork.er.swiftcare.dto.ClinicResponse;
import org.postwork.er.swiftcare.dto.CreateClinicRequest;
import org.postwork.er.swiftcare.dto.UpdatePatientRequest;
import org.postwork.er.swiftcare.dto.WaitTimeResponse;
import org.postwork.er.swiftcare.service.ClinicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinics")
@RequiredArgsConstructor
public class ClinicController {

    private final ClinicService service;

    @PostMapping
    public ResponseEntity<ClinicResponse> createClinic(
            @Valid @RequestBody CreateClinicRequest request) {
        return ResponseEntity.ok(service.createClinic(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicResponse> getClinic(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getClinic(id));
    }

    @PatchMapping("/{id}/patients")
    public ResponseEntity<Void> updatePatients(
            @PathVariable UUID id,
            @Valid @RequestBody UpdatePatientRequest request) {

        service.updatePatientCount(id, request);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/wait-time")
    public ResponseEntity<WaitTimeResponse> getWaitTime(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getWaitTime(id));
    }

}

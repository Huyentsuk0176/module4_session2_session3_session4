package com.example.employee_api.doctor.service;

import com.example.employee_api.doctor.model.entity.Doctor;
import com.example.employee_api.doctor.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
    public Doctor updateDoctor(Long id, Doctor doctor) {

        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        existingDoctor.setDoctorCode(doctor.getDoctorCode());
        existingDoctor.setFullName(doctor.getFullName());
        existingDoctor.setSpecialization(doctor.getSpecialization());
        existingDoctor.setExperienceYears(doctor.getExperienceYears());

        return doctorRepository.save(existingDoctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
package com.ibm.onlinemedicinestore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.onlinemedicinestore.entity.Doctor;
import com.ibm.onlinemedicinestore.entity.Patient;
import com.ibm.onlinemedicinestore.entity.PatientReview;

public interface PatientReviewRepository extends JpaRepository<PatientReview, String> {
	public Optional<PatientReview> findByPatient(Patient patient);

	public Optional<PatientReview> findByDoctor(Doctor doctor);
}

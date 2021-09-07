package com.ibm.onlinemedicinestore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.onlinemedicinestore.entity.Doctor;
import com.ibm.onlinemedicinestore.entity.Patient;
import com.ibm.onlinemedicinestore.entity.PatientReview;
import com.ibm.onlinemedicinestore.repository.PatientReviewRepository;

@Service
public class PatientReviewService {
	@Autowired
	PatientReviewRepository patientReviewRepository;

	@Transactional
	public boolean saveReview(PatientReview patientReview) {
		if (patientReviewRepository.save(patientReview) != null) {
			return true;
		}
		return false;
	}

	@Transactional(readOnly = true)
	public PatientReview getPatientReviewByPatientId(String patientId) {
		Patient p = new Patient();
		p.setPatientId(patientId);
		Optional<PatientReview> pr = patientReviewRepository.findByPatient(p);
		if (pr.isPresent()) {
			return pr.get();
		}
		return null;
	}

	@Transactional(readOnly = true)
	public PatientReview getPatientReviewByDoctorId(String doctorId) {
		Doctor d = new Doctor();
		d.setDoctorId(doctorId);
		Optional<PatientReview> pr = patientReviewRepository.findByDoctor(d);
		if (pr.isPresent()) {
			return pr.get();
		}
		return null;
	}
}

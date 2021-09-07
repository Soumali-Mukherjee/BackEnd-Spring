package com.ibm.onlinemedicinestore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.onlinemedicinestore.entity.Patient;
import com.ibm.onlinemedicinestore.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	PatientRepository patientRepository;
	@Transactional
	public boolean savePatient(Patient patient) {
		if (patientRepository.save(patient) != null) {
			return true;
		}
		return false;
	}
	@Transactional(readOnly = true)
	public Patient getPatientByPatientId(String patientId) {
		Optional<Patient> p = patientRepository.findById(patientId);
		if (p.isPresent()) {
			return p.get();
		}
		return null;
	} 
	@Transactional
	public boolean modifyPatient(String emailId,long mobileNo,String patientPassword,String patientId) {
		int count = patientRepository.updatePatientDetails(emailId, mobileNo, patientPassword, patientId);
		if (count > 0) {
			return true;
		}
		return false;
	}
	
}

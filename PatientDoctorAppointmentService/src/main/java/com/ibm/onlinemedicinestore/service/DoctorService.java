package com.ibm.onlinemedicinestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.onlinemedicinestore.entity.Doctor;
import com.ibm.onlinemedicinestore.repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	DoctorRepository doctorRepository;

	@Transactional(readOnly = true)
	public List<Doctor> getDoctors() {
		return doctorRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Doctor> getDoctorBySpecialization(String specialization) {
		return doctorRepository.findBySpecialization(specialization);
	}

	@Transactional(readOnly = true)
	public List<Doctor> getDoctorByName(String doctorname) {
		return doctorRepository.findByDoctorname(doctorname);
	}
}

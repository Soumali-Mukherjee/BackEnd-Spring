package com.ibm.onlinemedicinestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.onlinemedicinestore.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
	List<Doctor> findByDoctorname(String doctorname);

	List<Doctor> findBySpecialization(String specialization);
}

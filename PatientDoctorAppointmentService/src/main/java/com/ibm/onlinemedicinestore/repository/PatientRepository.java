package com.ibm.onlinemedicinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.onlinemedicinestore.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {
	@Modifying
	@Query("update Patient p set p.emailId=:emailId, p.mobileNo=:mobileNo,p.patientPassword=:patientPassword where p.patientId=:patientId")
	public int updatePatientDetails(@Param("emailId") String emailId, @Param("mobileNo") long mobileNo,
			@Param("patientPassword") String patientPassword, @Param("patientId") String patientId);
}

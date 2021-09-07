package com.ibm.onlinemedicinestore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_details")
public class Patient {
	@Id
	@Column(name = "patient_id")
	String patientId;
	@Column(name = "patient_name")
	String patientName;
	@Column(name = "patient_password")
	String patientPassword;
	@Column(name = "age")
	int patientAge;
	@Column(name = "gender")
	String gender;
	@Column(name = "mobile")
	long mobileNo;
	@Column(name = "email")
	String emailId;

	public Patient() {
	}

	public Patient(String patientId, String patientName, String patientPassword, int patientAge, String gender,
			long mobileNo, String emailId) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientPassword = patientPassword;
		this.patientAge = patientAge;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}

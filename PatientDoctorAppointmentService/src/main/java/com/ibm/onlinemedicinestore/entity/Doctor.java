package com.ibm.onlinemedicinestore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor_details")
public class Doctor {
	@Id
	@Column(name = "doctor_id")
	String doctorId;
	@Column(name = "doctor_name")
	String doctorname;
	@Column(name = "mobile")
	long mobileNo;
	String gender;
	@Column(name = "email")
	String emailId;
	@Column(name = "qualification")
	String qualification;
	@Column(name = "speciality")
	String specialization;
	@Column(name = "fee")
	double fees;
	@Column(name = "experience")
	String experience;

	public Doctor() {
	}

	public Doctor(String doctorId, String doctorname, long mobileNo, String gender, String emailId,
			String qualification, String specialization, double fees, String experience) {
		this.doctorId = doctorId;
		this.doctorname = doctorname;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.emailId = emailId;
		this.qualification = qualification;
		this.specialization = specialization;
		this.fees = fees;
		this.experience = experience;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	

}

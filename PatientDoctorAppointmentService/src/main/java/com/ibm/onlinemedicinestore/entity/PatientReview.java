package com.ibm.onlinemedicinestore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_reviews")
public class PatientReview {
	@Id
	@Column(name = "review_id")
	String reviewId;
	/*@Column(name = "patient_id")
	String patientId;*/
	@OneToOne
	@JoinColumn(name = "patient_id")
	Patient patient;
	/*@Column(name = "doctor_id")
	String doctorId;*/
	@OneToOne
	@JoinColumn(name = "doctor_id")
	Doctor doctor;
	@Column(name = "description")
	String description;
	@Column(name = "rating")
	double rating;

	public PatientReview() {
	}

	public PatientReview(String reviewId, Patient patient, Doctor doctor, String description, double rating) {
		this.reviewId = reviewId;
		this.patient = patient;
		this.doctor = doctor;
		this.description = description;
		this.rating = rating;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}

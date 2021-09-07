package com.ibm.onlinemedicinestore.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_doctor_schedule_details")
public class AppointmentScheduleDetails {
	@Id
	@Column(name = "schedule_id")
	String scheduleId;
	/*
	 * @Column(name = "patient_id") String patientId;
	 */
	@OneToOne
	@JoinColumn(name = "patient_id")
	Patient patient;
	/*
	 * @Column(name = "doctor_id") String doctorId;
	 */
	@OneToOne
	@JoinColumn(name = "doctor_id")
	Doctor doctor;
	@Column(name = "appoint_date")
	LocalDate appointmentDate;
	@Column(name = "appoint_time")
	LocalTime appointmentTime;
	@Column(name = "status")
	String status;

	public AppointmentScheduleDetails() {
	}

	public AppointmentScheduleDetails(String scheduleId, Patient patient, Doctor doctor, LocalDate appointmentDate,
			LocalTime appointmentTime, String status) {
		this.scheduleId = scheduleId;
		this.patient = patient;
		this.doctor = doctor;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
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

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

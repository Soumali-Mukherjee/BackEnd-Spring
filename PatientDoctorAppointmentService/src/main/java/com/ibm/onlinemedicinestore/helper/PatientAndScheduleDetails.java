package com.ibm.onlinemedicinestore.helper;

import com.ibm.onlinemedicinestore.entity.Patient;
import com.ibm.onlinemedicinestore.entity.AppointmentScheduleDetails;

public class PatientAndScheduleDetails {
	Patient patient;
	AppointmentScheduleDetails appointmentScheduleDetails;

	public PatientAndScheduleDetails() {
	}

	public PatientAndScheduleDetails(Patient patient, AppointmentScheduleDetails appointmentScheduleDetails) {
		this.patient = patient;
		this.appointmentScheduleDetails = appointmentScheduleDetails;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public AppointmentScheduleDetails getAppoinmentScheduleDetails() {
		return appointmentScheduleDetails;
	}

	public void setAppoinmentScheduleDetails(AppointmentScheduleDetails appointmentScheduleDetails) {
		this.appointmentScheduleDetails = appointmentScheduleDetails;
	}

}

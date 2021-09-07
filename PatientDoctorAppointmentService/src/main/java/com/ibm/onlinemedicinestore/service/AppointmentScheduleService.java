package com.ibm.onlinemedicinestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.onlinemedicinestore.entity.AppointmentScheduleDetails;
import com.ibm.onlinemedicinestore.entity.Patient;
import com.ibm.onlinemedicinestore.repository.AppointmentScheduleDetailsRepository;

@Service
public class AppointmentScheduleService {
	@Autowired
	AppointmentScheduleDetailsRepository appointmentScheduleDetailsRepository;

	@Transactional
	public boolean fixPatientAndDoctorAppointment(AppointmentScheduleDetails appointmentScheduleDetails) {
		if ((appointmentScheduleDetailsRepository.save(appointmentScheduleDetails)) != null) {
			return true;
		}
		return false;
	}

	@Transactional
	public boolean modifyPatientAndDoctorAppointment(AppointmentScheduleDetails appointmentScheduleDetails) {
		if ((appointmentScheduleDetailsRepository.save(appointmentScheduleDetails)) != null) {
			return true;
		}
		return false;

	}

	@Transactional
	public boolean cancelPatientAndDoctorAppointment(AppointmentScheduleDetails appointmentScheduleDetails) {
		if ((appointmentScheduleDetailsRepository.save(appointmentScheduleDetails)) != null) {
			return true;
		}
		return false;
	}

	@Transactional(readOnly = true)
	public List<AppointmentScheduleDetails> viewAppointmentByPatientId(String patientId) {
		Patient p = new Patient();
		p.setPatientId(patientId);
		List<AppointmentScheduleDetails> appointmentScheduleDetails = appointmentScheduleDetailsRepository
				.findByPatient(p);
		return appointmentScheduleDetails;
	}

	@Transactional
	public boolean cancelPatientAppointment(String status, String scheduleId) {
		int count = appointmentScheduleDetailsRepository.updateStatus(status, scheduleId);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Transactional
	public boolean modifyAppointmentDateAndTime(AppointmentScheduleDetails appointmentScheduleDetails) {
		int count = appointmentScheduleDetailsRepository.updateAppointmentDateAndAppointmentTime(
				appointmentScheduleDetails.getAppointmentDate(), appointmentScheduleDetails.getAppointmentTime(),
				appointmentScheduleDetails.getScheduleId());
		if (count > 0) {
			return true;
		}
		return false;
	}
}

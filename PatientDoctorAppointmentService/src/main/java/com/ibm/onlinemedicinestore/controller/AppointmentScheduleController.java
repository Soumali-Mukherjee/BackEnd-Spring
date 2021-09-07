package com.ibm.onlinemedicinestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.onlinemedicinestore.entity.Doctor;
import com.ibm.onlinemedicinestore.entity.Patient;
import com.ibm.onlinemedicinestore.entity.PatientReview;
import com.ibm.onlinemedicinestore.entity.AppointmentScheduleDetails;
//import com.ibm.onlinemedicinestore.helper.PatientAndScheduleDetails;
import com.ibm.onlinemedicinestore.service.DoctorService;
import com.ibm.onlinemedicinestore.service.PatientReviewService;
import com.ibm.onlinemedicinestore.service.AppointmentScheduleService;
import com.ibm.onlinemedicinestore.service.PatientService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AppointmentScheduleController {
	@Autowired
	AppointmentScheduleService appointmentScheduleService;
	@Autowired
	PatientService patientService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	PatientReviewService patientReviewService;

	@GetMapping(value = "/doctors", produces = "application/json")
	public ResponseEntity<List<Doctor>> getDoctors() {
		return new ResponseEntity<List<Doctor>>(doctorService.getDoctors(), HttpStatus.OK);
	}

	@GetMapping(value = "/specialization/{specialization}", produces = "application/json")
	public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@PathVariable String specialization) {
		return new ResponseEntity<List<Doctor>>(doctorService.getDoctorBySpecialization(specialization), HttpStatus.OK);
	}

	@GetMapping(value = "/name/{doctorname}", produces = "application/json")
	public ResponseEntity<List<Doctor>> getDoctorByName(@PathVariable String doctorname) {
		List<Doctor> d = doctorService.getDoctorByName(doctorname);
		if (d != null)
			return new ResponseEntity<List<Doctor>>(d, HttpStatus.OK);
		return new ResponseEntity<List<Doctor>>(d, HttpStatus.NOT_FOUND);
	}

	/*
	 * @PostMapping(consumes = "application/json") public HttpStatus
	 * fixPatientAppointment(@RequestBody PatientAndScheduleDetails
	 * patientAndScheduleDetails) { if
	 * (appointmentScheduleService.fixPatientAndDoctorAppointment(
	 * patientAndScheduleDetails.getAppoinmentScheduleDetails())) {
	 * patientService.savePatient(patientAndScheduleDetails.getPatient()); return
	 * HttpStatus.OK; } return HttpStatus.FAILED_DEPENDENCY; }
	 */
	@PostMapping(consumes = "application/json")
	public HttpStatus fixPatientAppointment(@RequestBody AppointmentScheduleDetails appointmentScheduleDetails) {
		if (patientService.savePatient(appointmentScheduleDetails.getPatient())) {
			appointmentScheduleService.fixPatientAndDoctorAppointment(appointmentScheduleDetails);
			return HttpStatus.OK;
		}
		return HttpStatus.FAILED_DEPENDENCY;
	}

	@PutMapping(consumes = "application/json")
	public HttpStatus modifyPatientAppointment(@RequestBody AppointmentScheduleDetails appointmentScheduleDetails) {
		/*
		 * if (appointmentScheduleService.modifyPatientAndDoctorAppointment(
		 * appointmentScheduleDetails)) { return HttpStatus.OK; }
		 */
		if (appointmentScheduleService.modifyAppointmentDateAndTime(appointmentScheduleDetails)) {
			return HttpStatus.OK;
		}
		return HttpStatus.FAILED_DEPENDENCY;

	}

	@PutMapping(value = "/cancel", consumes = "application/json")
	public HttpStatus cancelPatientAppointment(@RequestBody AppointmentScheduleDetails appointmentScheduleDetails) {
		// if
		// (appointmentScheduleService.cancelPatientAndDoctorAppointment(appointmentScheduleDetails))
		// {
		if (appointmentScheduleService.cancelPatientAppointment("C", appointmentScheduleDetails.getScheduleId())) {
			return HttpStatus.OK;
		}
		return HttpStatus.FAILED_DEPENDENCY;
	}

	@GetMapping(value = "/viewAppointment/{patientId}", produces = "application/json")
	public ResponseEntity<List<AppointmentScheduleDetails>> viewAppointmentByPatientId(@PathVariable String patientId) {
		return new ResponseEntity<List<AppointmentScheduleDetails>>(
				appointmentScheduleService.viewAppointmentByPatientId(patientId), HttpStatus.OK);
	}

	@GetMapping(value = "/patientId/{patientId}", produces = "application/json")
	public ResponseEntity<Patient> getPatient(@PathVariable String patientId) {
		Patient b = patientService.getPatientByPatientId(patientId);
		if (b != null) {
			return new ResponseEntity<Patient>(b, HttpStatus.OK);
		}
		return new ResponseEntity<Patient>(b, HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/modifyPatient", consumes = "application/json")
	public HttpStatus modifyPatientDetails(@RequestBody Patient patient) {
		if (patientService.modifyPatient(patient.getEmailId(),patient.getMobileNo(),patient.getPatientPassword(),patient.getPatientId())) {
			return HttpStatus.OK;
		}
		return HttpStatus.FAILED_DEPENDENCY;
	}

	@PutMapping(value = "/addReview", consumes = "application/json")
	public HttpStatus addPatientReview(@RequestBody PatientReview patientReview) {
		if (patientReviewService.saveReview(patientReview)) {
			return HttpStatus.OK;
		}
		return HttpStatus.FAILED_DEPENDENCY;
	}

	@GetMapping(value = "/reviewByPatient/{patientId}", produces = "application/json")
	public ResponseEntity<PatientReview> getPatientReviewByPatientId(@PathVariable String patientId) {
		PatientReview pr = patientReviewService.getPatientReviewByPatientId(patientId);
		if (pr != null) {
			return new ResponseEntity<PatientReview>(pr, HttpStatus.OK);
		}
		return new ResponseEntity<PatientReview>(pr, HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/reviewByDoctor/{doctorId}", produces = "application/json")
	public ResponseEntity<PatientReview> getPatientReviewByDoctorId(@PathVariable String doctorId) {
		PatientReview pr = patientReviewService.getPatientReviewByDoctorId(doctorId);
		if (pr != null) {
			return new ResponseEntity<PatientReview>(pr, HttpStatus.OK);
		}
		return new ResponseEntity<PatientReview>(pr, HttpStatus.NOT_FOUND);
	}

}

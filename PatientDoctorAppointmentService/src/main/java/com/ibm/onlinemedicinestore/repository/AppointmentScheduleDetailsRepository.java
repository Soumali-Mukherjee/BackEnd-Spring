package com.ibm.onlinemedicinestore.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.onlinemedicinestore.entity.AppointmentScheduleDetails;
import com.ibm.onlinemedicinestore.entity.Patient;

public interface AppointmentScheduleDetailsRepository extends JpaRepository<AppointmentScheduleDetails, String> {
	List<AppointmentScheduleDetails> findByPatient(Patient patient);

	@Modifying
	@Query("update AppointmentScheduleDetails a set  a.status=:status where a.scheduleId=:scheduleId")
	public int updateStatus(@Param("status") String status, @Param("scheduleId") String scheduleId);

	@Modifying
	@Query("update AppointmentScheduleDetails a set a.appointmentDate=:appointmentDate, a.appointmentTime=:appointmentTime where a.scheduleId=:scheduleId")
	public int updateAppointmentDateAndAppointmentTime(@Param("appointmentDate") LocalDate appointmentDate,
			@Param("appointmentTime") LocalTime appointmentTime, @Param("scheduleId") String scheduleId);
}

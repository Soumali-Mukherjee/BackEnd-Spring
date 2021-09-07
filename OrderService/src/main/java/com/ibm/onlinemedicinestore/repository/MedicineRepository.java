package com.ibm.onlinemedicinestore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.onlinemedicinestore.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String> {
	public Optional<List<Medicine>> findByMfgCompany (String mfgCompany);

}
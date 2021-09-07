package com.ibm.onlinemedicinestore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.onlinemedicinestore.entity.Medicine;
import com.ibm.onlinemedicinestore.repository.MedicineRepository;

@Service
public class MedicineService {
	@Autowired
	MedicineRepository medicineRepository;
	@Transactional(readOnly = true)
	public List<Medicine> getAllMedicine() {
		return medicineRepository.findAll();
	}
	@Transactional(readOnly = true)
	public Medicine getMedicineByName(String medicineName) {
		Optional<Medicine> m = medicineRepository.findById(medicineName);
		if (m.isPresent()) {
			return m.get();
		}
		return null;
	}
	@Transactional(readOnly = true)
	public List<Medicine> getMedicineByBrand(String mfgCompany) {
		Optional <List<Medicine>> m = medicineRepository.findByMfgCompany(mfgCompany);
		if (m.isPresent()) {
			return m.get();
		}
		return null;
	}
}

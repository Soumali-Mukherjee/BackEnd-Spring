package com.ibm.onlinemedicinestore.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicine_details")
public class Medicine {
	@Id
	@Column(name = "medicine_name")
	String medicineName;
	@Column(name = "type")
	String type;
	@Column(name = "mfg_company")
	String mfgCompany;
	@Column(name = "mfg_date")
	LocalDate mfgDate;
	@Column(name = "exp_date")
	LocalDate expDate;
	@Column(name = "price")
	long price;
	@Column(name = "unit")
	int unit;
	@Column(name = "prescription_required")
	String prescriptionRequired;
	@Column(name="description")
	String description;

	public Medicine() {
	}

	public Medicine(String medicineName, String type, String mfgCompany, LocalDate mfgDate, LocalDate expDate,
			long price, int unit, String prescriptionRequired,String description) {
		
		this.medicineName = medicineName;
		this.type = type;
		this.mfgCompany = mfgCompany;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.price = price;
		this.unit = unit;
		this.prescriptionRequired = prescriptionRequired;
		this.description=description;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMfgCompany() {
		return mfgCompany;
	}

	public void setMfgCompany(String mfgCompany) {
		this.mfgCompany = mfgCompany;
	}

	public LocalDate getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(LocalDate mfgDate) {
		this.mfgDate = mfgDate;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public String getPrescriptionRequired() {
		return prescriptionRequired;
	}

	public void setPrescriptionRequired(String prescriptionRequired) {
		this.prescriptionRequired = prescriptionRequired;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
	

	
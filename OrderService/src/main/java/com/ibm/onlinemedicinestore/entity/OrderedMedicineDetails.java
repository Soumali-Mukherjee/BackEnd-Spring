package com.ibm.onlinemedicinestore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordered_medicine_details")
public class OrderedMedicineDetails {
	@Id
	@Column(name = "id")
	long id;
	@Column(name = "order_id")
	String orderId;
	@OneToOne
	@JoinColumn(name = "medicine_name")
	Medicine medicine;
	@Column(name = "qty")
	int quantity;
	@Column(name = "price")
	double price;

	public OrderedMedicineDetails() {
	}

	public OrderedMedicineDetails(long id, String orderId, Medicine medicine, int quantity, double price) {
		this.id = id;
		this.orderId = orderId;

		this.medicine = medicine;
		this.quantity = quantity;
		this.price = price;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

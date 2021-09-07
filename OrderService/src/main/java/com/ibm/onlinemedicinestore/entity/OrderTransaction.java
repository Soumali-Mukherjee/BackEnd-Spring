package com.ibm.onlinemedicinestore.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_transactions")
public class OrderTransaction {
	@Id
	@Column(name = "order_id")
	String orderId;
	@Column(name = "user_name")
	String userName;
	@Column(name = "order_date")
	LocalDate orderDate;
	@Column(name = "order_time")
	LocalTime orderTime;
	@Column(name = "bill_amount")
	double billAmount;
	@Column(name = "payment_mode")
	String paymentMode;
	@OneToOne
	@JoinColumn(name="add_id")
	Address address;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
	List<OrderedMedicineDetails> orderedMedicines;

	public OrderTransaction() {
	}

	public OrderTransaction(String orderId, String userName, LocalDate orderDate, LocalTime orderTime, double billAmount,
			String paymentMode,Address address,List<OrderedMedicineDetails> orderedMedicines) {
		this.orderId = orderId;
		this.userName = userName;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.billAmount = billAmount;
		this.paymentMode = paymentMode;
		this.address = address;
		this.orderedMedicines = orderedMedicines;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<OrderedMedicineDetails> getOrderedMedicines() {
		return orderedMedicines;
	}

	public void setOrderedMedicines(List<OrderedMedicineDetails> orderedMedicines) {
		this.orderedMedicines = orderedMedicines;
	}
	

}

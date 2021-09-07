package com.ibm.onlinemedicinestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.onlinemedicinestore.entity.Medicine;
import com.ibm.onlinemedicinestore.entity.OrderTransaction;
import com.ibm.onlinemedicinestore.service.AddressService;
import com.ibm.onlinemedicinestore.service.MedicineService;
import com.ibm.onlinemedicinestore.service.OrderDetailsService;
import com.ibm.onlinemedicinestore.service.OrderTransactionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderDetailsController {

	@Autowired
	OrderDetailsService orderDetailsService;
	@Autowired
	MedicineService medicineService;
	@Autowired
	OrderTransactionService orderTransactionService;
	@Autowired
	AddressService addressService;

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Medicine>> getAllMedicines() {
		return new ResponseEntity<List<Medicine>>(medicineService.getAllMedicine(), HttpStatus.OK);
	}

	@GetMapping(value = "/{medicineName}", produces = "application/json")
	public ResponseEntity<Medicine> findMedicineByName(@PathVariable String medicineName) {
		Medicine m = medicineService.getMedicineByName(medicineName);
		if (m != null) {
			return new ResponseEntity<Medicine>(m, HttpStatus.OK);
		} else {
			return new ResponseEntity<Medicine>(m, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/findByBrand/{mfgCompany}", produces = "application/json")
	public ResponseEntity<List<Medicine>> findMedicineByBrand(@PathVariable String mfgCompany) {
		List<Medicine> m = medicineService.getMedicineByBrand(mfgCompany);
		if (m != null) {
			return new ResponseEntity<List<Medicine>>(m, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Medicine>>(m, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(consumes = "application/json")
	public HttpStatus addOrder(@RequestBody OrderTransaction orderTransaction) {
		if(addressService.addAddress(orderTransaction.getAddress())) {
			if (orderTransactionService.insertOrderTransaction(orderTransaction)) {
				return HttpStatus.OK;
			}
			else {
				return HttpStatus.NOT_MODIFIED;
			}
		}
		return HttpStatus.NOT_MODIFIED;
			
	}

	@GetMapping(value = "/ordersbyusername/{userName}", produces = "application/json")
	public ResponseEntity<List<OrderTransaction>> getOrderTransactionsByUserName(@PathVariable String userName) {
		return new ResponseEntity<List<OrderTransaction>>(
				orderTransactionService.getOrderTransactionsByUserName(userName), HttpStatus.OK);
	}

}

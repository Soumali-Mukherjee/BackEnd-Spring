package com.ibm.onlinemedicinestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.onlinemedicinestore.entity.OrderedMedicineDetails;
import com.ibm.onlinemedicinestore.repository.OrderDetailsRepository;

@Service
public class OrderDetailsService {
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	@Transactional(readOnly = true)
	public List<OrderedMedicineDetails> findAllOrders(){
		return orderDetailsRepository.findAll();
	}

}

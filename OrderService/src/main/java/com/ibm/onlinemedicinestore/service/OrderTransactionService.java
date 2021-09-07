package com.ibm.onlinemedicinestore.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.onlinemedicinestore.entity.OrderTransaction;
import com.ibm.onlinemedicinestore.repository.OrderTransactionRepository;

@Service
public class OrderTransactionService {
	@Autowired
	OrderTransactionRepository orderTransactionRepository;
	
	public boolean insertOrderTransaction(OrderTransaction orderTransaction) 
	{
		OrderTransaction ot = orderTransactionRepository.save(orderTransaction);
		return ot!=null;
		
	}
	
	public List<OrderTransaction> getOrderTransactionsByUserName(String userName)
	{
		return orderTransactionRepository.findByUserName(userName);
	}
}

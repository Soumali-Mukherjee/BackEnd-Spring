package com.ibm.onlinemedicinestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.onlinemedicinestore.entity.OrderTransaction;

public interface OrderTransactionRepository extends JpaRepository<OrderTransaction, String> {
	List<OrderTransaction> findByUserName(String userName);
}

package com.ibm.onlinemedicinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.onlinemedicinestore.entity.OrderedMedicineDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderedMedicineDetails, String> {

}

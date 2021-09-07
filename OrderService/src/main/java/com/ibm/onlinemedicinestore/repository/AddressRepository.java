package com.ibm.onlinemedicinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.onlinemedicinestore.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}

package com.ibm.onlinemedicinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.onlinemedicinestore.entity.Address;
import com.ibm.onlinemedicinestore.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;
	@Transactional
	public boolean addAddress(Address address) {
		return (addressRepository.save(address)) !=null;
	}
}

package com.rroager.addressservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rroager.addressservice.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}

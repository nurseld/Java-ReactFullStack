package com.tobeto.rentalcardemo.repository;

import com.tobeto.rentalcardemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository <Address, Integer>{
}

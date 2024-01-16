package com.tobeto.rentalcardemo.repositories;

import com.tobeto.rentalcardemo.entities.concretes.Address;
import com.tobeto.rentalcardemo.services.dto.address.responses.GetAllAddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository <Address, Integer>{

    @Query("Select new com.tobeto.rentalcardemo.services.dto.address.responses.GetAllAddressResponse(a.id,a.cityName,a.locationName,a.countryName,a.districtName,a.streetName,a.postCode)" +
            " FROM Address a WHERE a.cityName = :cityName")
    List<GetAllAddressResponse> findByCityName(String cityName);
    List<Address> findByDistrictNameStartingWith(String districtName);

    @Query("Select new com.tobeto.rentalcardemo.services.dto.address.responses.GetAllAddressResponse(a.id,a.cityName,a.locationName,a.countryName,a.districtName,a.streetName,a.postCode)" +
            " FROM Address a ORDER BY a.streetName DESC")
    List<GetAllAddressResponse> findByStreetName();
}

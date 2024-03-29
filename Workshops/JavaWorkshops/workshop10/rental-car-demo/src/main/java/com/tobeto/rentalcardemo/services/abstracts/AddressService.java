package com.tobeto.rentalcardemo.services.abstracts;

import com.tobeto.rentalcardemo.entities.concretes.Address;
import com.tobeto.rentalcardemo.services.dto.address.requests.AddAddressRequest;
import com.tobeto.rentalcardemo.services.dto.address.requests.UpdateAddressRequest;
import com.tobeto.rentalcardemo.services.dto.address.responses.AddAddressResponse;
import com.tobeto.rentalcardemo.services.dto.address.responses.GetAllAddressResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    AddAddressResponse add(AddAddressRequest request);
    List<GetAllAddressResponse> getAll();
    GetAllAddressResponse getById(Integer addressId);
    void delete(Integer addressId);
    void update(Integer addressId, UpdateAddressRequest request);
    List<GetAllAddressResponse> getByCityName(String cityName);
    List<Address> getDistrictName(String districtName);
    List<GetAllAddressResponse> getByStreetName();

}

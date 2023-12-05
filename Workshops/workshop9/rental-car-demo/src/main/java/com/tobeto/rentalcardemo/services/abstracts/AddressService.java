package com.tobeto.rentalcardemo.services.abstracts;

import com.tobeto.rentalcardemo.entity.Address;
import com.tobeto.rentalcardemo.services.dto.address.requests.AddAddressRequest;
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
    void update(Integer addressId, AddAddressRequest request);
    List<GetAllAddressResponse> getByCityName(String cityName);
    List<Address> getDistrictName(String districtName);
    List<GetAllAddressResponse> getByStreetName();
}

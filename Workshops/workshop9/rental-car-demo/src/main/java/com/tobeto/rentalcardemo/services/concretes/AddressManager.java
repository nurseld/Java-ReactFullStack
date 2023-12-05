package com.tobeto.rentalcardemo.services.concretes;

import com.tobeto.rentalcardemo.entity.Address;
import com.tobeto.rentalcardemo.repository.AddressRepository;
import com.tobeto.rentalcardemo.services.abstracts.AddressService;
import com.tobeto.rentalcardemo.services.dto.address.requests.AddAddressRequest;
import com.tobeto.rentalcardemo.services.dto.address.responses.AddAddressResponse;
import com.tobeto.rentalcardemo.services.dto.address.responses.GetAllAddressResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressManager implements AddressService {

    private final AddressRepository addressRepository;

    public AddressManager(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddAddressResponse add(AddAddressRequest request) {

        Address address = new Address();

        address.setLocationName(request.getLocationName());
        address.setCountryName(request.getCountryName());
        address.setCityName(request.getCityName());
        address.setStreetName(request.getStreetName());
        address.setDistrictName(request.getDistrictName());
        address.setPostCode(request.getPostCode());

        Address savedAddress = addressRepository.save(address);
        AddAddressResponse response = new AddAddressResponse();
        response.setId(savedAddress.getAddressId());
        return response;
    }

    @Override
    public List<GetAllAddressResponse> getAll() {
/*
       List<Address> addressList = addressRepository.findAll();
       List<GetAllAddressResponse> responses = new ArrayList<>();

       for (Address address : addressList) {

            GetAllAddressResponse response = new GetAllAddressResponse();

            response.setStreetName(address.getStreetName());
            response.setCityName(address.getCityName());
            response.setCountryName(address.getCountryName());
            response.setDistrictName(address.getDistrictName());
            response.setPostCode(address.getPostCode());
            response.setLocationName(address.getLocationName());

            responses.add(response);
        }

       return responses;*/
        return addressRepository.findAll()
                .stream()
                .map(address -> new GetAllAddressResponse(address.getAddressId(),
                        address.getCityName(),
                        address.getLocationName(),
                        address.getCountryName(),
                        address.getDistrictName(),
                        address.getStreetName(),
                        address.getPostCode()))
                .toList();

    }

    @Override
    public GetAllAddressResponse getById(Integer addressId) {

        Address adressInDb = addressRepository.findById(addressId)
                .orElseThrow(()-> new RuntimeException("Address does not exist."));

        GetAllAddressResponse response = new GetAllAddressResponse();

        response.setCityName(adressInDb.getCityName());
        response.setCountryName(adressInDb.getCountryName());
        response.setDistrictName(adressInDb.getDistrictName());
        response.setPostCode(adressInDb.getPostCode());
        response.setLocationName(adressInDb.getLocationName());
        response.setStreetName(adressInDb.getStreetName());

        return response;
    }

    @Override
    public void delete(Integer addressId) {

        addressRepository.deleteById(addressId);

    }

    @Override
    public void update(Integer addressId, AddAddressRequest request) {

        Address address = addressRepository.findById(addressId).orElseThrow(()-> new RuntimeException("Address does not exist."));

        address.setLocationName(request.getLocationName());
        address.setCountryName(request.getCountryName());
        address.setStreetName(request.getStreetName());
        address.setCityName(request.getCityName());
        address.setPostCode(request.getPostCode());
        address.setDistrictName(request.getDistrictName());

        addressRepository.save(address);
    }

    @Override
    public List<GetAllAddressResponse> getByCityName(String cityName) {

       // return addressRepository.findByCityName(cityName);

        return addressRepository.findAll()
                .stream()
                .filter((address -> address.getCityName().equals(cityName)))
                .map((address -> new GetAllAddressResponse(address.getAddressId(),
                        address.getCityName(),
                        address.getLocationName(),
                        address.getCountryName(),
                        address.getDistrictName(),
                        address.getStreetName(),
                        address.getPostCode())))
                .toList();


    }

    @Override
    public List<Address> getDistrictName(String districtName) {

        return addressRepository.findByDistrictNameStartingWith(districtName);
    }

    @Override
    public List<GetAllAddressResponse> getByStreetName() {

        return addressRepository.findByStreetName().stream().map((address) -> {
            return new GetAllAddressResponse(address.getId(),
                    address.getCityName(),
                    address.getLocationName(),
                    address.getCountryName(),
                    address.getDistrictName(),
                    address.getStreetName(),
                    address.getPostCode());})
                .toList();
    }


}




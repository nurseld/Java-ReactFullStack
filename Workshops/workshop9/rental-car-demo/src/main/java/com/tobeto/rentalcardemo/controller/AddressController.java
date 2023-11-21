package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.dto.AddressRequest;
import com.tobeto.rentalcardemo.entity.Address;
import com.tobeto.rentalcardemo.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @PostMapping
    public String create(@RequestBody Address address){

        addressRepository.save(address);
        return "Address has been saved to DB.";
    }
    @GetMapping
    public List<Address> getAll(){

        return addressRepository.findAll();

    }

    @GetMapping("/{addressId}")
    public Address getById(@PathVariable Integer addressId){

        return addressRepository.findById(addressId)
                .orElseThrow(()->new RuntimeException("Address does not exist."));
    }

    @DeleteMapping("/{addressId}")
    public void delete(@PathVariable Integer addressId){

        addressRepository.deleteById(addressId);
    }

    @PutMapping
    public void update(@RequestBody AddressRequest request){

        Address addressInDb = addressRepository.findById(request.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address does not exist."));
        addressInDb.setLocationName(request.getLocationName());
        addressInDb.setCountryName(request.getCountryName());
        addressInDb.setCityName(request.getCityName());
        addressInDb.setDistrictName(request.getDistrictName());
        addressInDb.setStreetName(request.getStreetName());
        addressInDb.setPostCode(request.getPostCode());

        addressRepository.save(addressInDb);

    }
}

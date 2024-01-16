package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.entities.concretes.Address;
import com.tobeto.rentalcardemo.services.abstracts.AddressService;
import com.tobeto.rentalcardemo.services.dto.address.requests.AddAddressRequest;
import com.tobeto.rentalcardemo.services.dto.address.requests.UpdateAddressRequest;
import com.tobeto.rentalcardemo.services.dto.address.responses.AddAddressResponse;
import com.tobeto.rentalcardemo.services.dto.address.responses.GetAllAddressResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public AddAddressResponse add(@RequestBody @Valid AddAddressRequest request){

        return addressService.add(request);

    }


    @GetMapping
    public List<GetAllAddressResponse> getAlL(){

        return addressService.getAll();

    }

    @GetMapping("/{addressId}")
    public GetAllAddressResponse getById(@PathVariable Integer addressId){

        return addressService.getById(addressId);
    }

    @DeleteMapping("/{addressId}")
    public void delete(@PathVariable Integer addressId){

        addressService.delete(addressId);
    }

    @PutMapping("/{addressId}")
    public void update(@PathVariable Integer addressId, @RequestBody @Valid UpdateAddressRequest request){

        addressService.update(addressId,request);

    }

    @GetMapping("/cityName")
    public List<GetAllAddressResponse> getByCityName(@RequestParam String cityName){

        return addressService.getByCityName(cityName);

    }

    @GetMapping("/districtName")
    public List<Address> getBydDistrict(@RequestParam String districtName){

        return addressService.getDistrictName(districtName);
    }

    @GetMapping("/streetName")
    public List<GetAllAddressResponse> getByStreetName(){

        return addressService.getByStreetName();
    }

}

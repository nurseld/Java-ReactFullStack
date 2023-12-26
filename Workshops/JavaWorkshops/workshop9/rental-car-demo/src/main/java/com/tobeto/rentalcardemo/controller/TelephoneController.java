package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.entity.Telephone;
import com.tobeto.rentalcardemo.services.abstracts.TelephoneService;
import com.tobeto.rentalcardemo.services.dto.telephone.requests.AddTelephoneRequest;
import com.tobeto.rentalcardemo.services.dto.telephone.requests.UpdateTelephoneRequest;
import com.tobeto.rentalcardemo.services.dto.telephone.responses.AddTelephoneResponse;
import com.tobeto.rentalcardemo.services.dto.telephone.responses.GetAllTelephoneResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telephones")
public class TelephoneController {

    private final TelephoneService telephoneService;

    public TelephoneController(TelephoneService telephoneService) {
        this.telephoneService = telephoneService;
    }


    @PostMapping
    public AddTelephoneResponse add(@RequestBody @Valid AddTelephoneRequest request){

       return telephoneService.add(request);
    }

    @GetMapping
    public List<GetAllTelephoneResponse> getAll(){

        return telephoneService.getAll();
    }

    @GetMapping("/{telephoneId}")
    public GetAllTelephoneResponse getById(@PathVariable Integer telephoneId){

        return telephoneService.getById(telephoneId);
    }

    @DeleteMapping("/{telephoneId}")
    public void delete(@PathVariable Integer telephoneId){

        telephoneService.delete(telephoneId);
    }


    @PutMapping
    public void update(@RequestBody UpdateTelephoneRequest request){

        telephoneService.update(request);
    }

    @GetMapping("description")
    public List<Telephone> getDescription(@RequestParam String description){

        return telephoneService.getDescription(description);
    }

    @GetMapping("phoneNumber")
    public List<GetAllTelephoneResponse> getDetailPhone(@RequestParam String phoneNumber){

        return telephoneService.getDetailPhone(phoneNumber);
    }
}

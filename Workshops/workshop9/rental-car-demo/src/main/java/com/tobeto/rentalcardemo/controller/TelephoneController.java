package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.entity.Telephone;
import com.tobeto.rentalcardemo.repository.CustomerRepository;
import com.tobeto.rentalcardemo.repository.TelephoneRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telephones")
public class TelephoneController {

    private final TelephoneRepository telephoneRepository;
    private final CustomerRepository customerRepository;

    public TelephoneController(TelephoneRepository telephoneRepository, CustomerRepository customerRepository) {
        this.telephoneRepository = telephoneRepository;
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public String create(@RequestBody Telephone telephone){

       telephoneRepository.save(telephone);
        return "Telephone number has been saved to DB.";
    }

    @GetMapping
    public List<Telephone> getAll(){

        return telephoneRepository.findAll();
    }

    @GetMapping("/{telephoneId}")
    public Telephone getById(@RequestParam Integer telephoneId){

        return telephoneRepository.findById(telephoneId)
                .orElseThrow(() -> new RuntimeException("Telephone does not exist."));
    }

    @DeleteMapping("/{telephoneId}")
    public void delete(@RequestParam Integer telephoneId){

        telephoneRepository.deleteById(telephoneId);
    }


    @PutMapping("/{telephoneId}")
    public void update(@PathVariable Integer telephoneId, @RequestParam String description, @RequestParam String phoneNumber){

        Telephone telephoneInDb = telephoneRepository.findById(telephoneId)
                .orElseThrow(()-> new RuntimeException("Telephone does not exist."));

        telephoneInDb.setDescription(description);
        telephoneInDb.setPhoneNumber(phoneNumber);

        telephoneRepository.save(telephoneInDb);
    }
}

package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.dto.CustomerRequest;
import com.tobeto.rentalcardemo.entity.Customer;
import com.tobeto.rentalcardemo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public String create(@RequestBody Customer customer){

        customerRepository.save(customer);
        return "Customer has been saved to DB.";
    }

    @GetMapping("/{customerId}")
    public Customer getById(@PathVariable Integer customerId){

        return customerRepository.findById(customerId)
                .orElseThrow(()-> new RuntimeException("Customer does not exist."));
    }

    @GetMapping
    public List<Customer> getAll(){

        return customerRepository.findAll();

    }
    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable Integer customerId){

        customerRepository.deleteById(customerId);
    }

    @PutMapping
    public void update(@RequestBody CustomerRequest request){

        Customer customerInDb = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer does not exist."));

        customerInDb.setFirstName(request.getFirstName());
        customerInDb.setMiddleName(request.getMiddleName());
        customerInDb.setSurName(request.getSurName());
        customerInDb.setAge(request.getAge());
        customerInDb.setCitizenShipId(request.getCitizenShipId());

        customerRepository.save(customerInDb);
    }
}

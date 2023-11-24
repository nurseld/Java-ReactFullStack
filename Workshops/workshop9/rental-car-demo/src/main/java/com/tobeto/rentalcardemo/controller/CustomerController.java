package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.entity.Customer;
import com.tobeto.rentalcardemo.services.abstracts.CustomerService;
import com.tobeto.rentalcardemo.services.dto.customer.requests.AddCustomerRequest;
import com.tobeto.rentalcardemo.services.dto.customer.responses.AddCustomerResponse;
import com.tobeto.rentalcardemo.services.dto.customer.responses.GetAllCustomerResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping
    public AddCustomerResponse add(@RequestBody AddCustomerRequest request){

        return customerService.add(request);
    }

    @GetMapping("/{customerId}")
    public GetAllCustomerResponse getById(@PathVariable Integer customerId){

        return customerService.getById(customerId);
    }

    @GetMapping
    public List<GetAllCustomerResponse> getAll(){

        return customerService.getAll();

    }
    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable Integer customerId){

        customerService.delete(customerId);
    }

    @PutMapping("/{customerId}")
    public void update(@PathVariable Integer customerId, @RequestBody AddCustomerRequest request){

        customerService.update(customerId,request);
    }

    @GetMapping("age")
    public List<Customer> getByAge(@RequestParam Integer age){

        return customerService.getByAge(age);
    }

    @GetMapping("lastName")
    public List<GetAllCustomerResponse> getByLastName(@RequestParam String lastName){

        return customerService.getLastName(lastName);
    }
}

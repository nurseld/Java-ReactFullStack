package com.tobeto.rentalcardemo.services.abstracts;

import com.tobeto.rentalcardemo.entities.concretes.Customer;
import com.tobeto.rentalcardemo.services.dto.customer.requests.AddCustomerRequest;
import com.tobeto.rentalcardemo.services.dto.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentalcardemo.services.dto.customer.responses.AddCustomerResponse;
import com.tobeto.rentalcardemo.services.dto.customer.responses.GetAllCustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    AddCustomerResponse add(AddCustomerRequest request);
    List<GetAllCustomerResponse> getAll();
    GetAllCustomerResponse getById(Integer customerId);
    void delete(Integer customerId);
    void update(UpdateCustomerRequest request);
    List<Customer> getByAge(Integer age);
    List<GetAllCustomerResponse> getLastName(String lastName);
}

package com.tobeto.rentalcardemo.services.concretes;

import com.tobeto.rentalcardemo.entity.Customer;
import com.tobeto.rentalcardemo.repository.CustomerRepository;
import com.tobeto.rentalcardemo.services.abstracts.CustomerService;
import com.tobeto.rentalcardemo.services.dto.customer.requests.AddCustomerRequest;
import com.tobeto.rentalcardemo.services.dto.customer.responses.AddCustomerResponse;
import com.tobeto.rentalcardemo.services.dto.customer.responses.GetAllCustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public AddCustomerResponse add(AddCustomerRequest request) {

        Customer customer = new Customer();

        customer.setFirstName(request.getFirstName());
        customer.setMiddleName(request.getMiddleName());
        customer.setSurName(request.getSurName());
        customer.setAge(request.getAge());

        Customer savedCustomer = customerRepository.save(customer);
        AddCustomerResponse response = new AddCustomerResponse();
        response.setId(savedCustomer.getCustomerId());

        return response;
    }

    @Override
    public List<GetAllCustomerResponse> getAll() {

/*        List<Customer> customerList = customerRepository.findAll();
        List<GetAllCustomerResponse> responses = new ArrayList<>();

        for (Customer customer : customerList) {

            GetAllCustomerResponse response = new GetAllCustomerResponse();

            response.setFirstName(customer.getFirstName());
            response.setMiddleName(customer.getMiddleName());
            response.setSurName(customer.getSurName());
            response.setAge(customer.getAge());


            responses.add(response);
        }

        return responses;*/

        return customerRepository.findAll()
                .stream()
                .map((customer) -> new GetAllCustomerResponse(customer.getFirstName(), customer.getMiddleName(), customer.getSurName(), customer.getAge())).toList();



    }

    @Override
    public GetAllCustomerResponse getById(Integer customerId) {

        Customer customerInDb = customerRepository.findById(customerId)
                .orElseThrow(()-> new RuntimeException("Customer does not exist."));

        GetAllCustomerResponse response = new GetAllCustomerResponse();

        response.setFirstName(customerInDb.getFirstName());
        response.setMiddleName(customerInDb.getMiddleName());
        response.setSurName(customerInDb.getSurName());
        response.setAge(customerInDb.getAge());

        return response;
    }

    @Override
    public void delete(Integer customerId) {

        customerRepository.deleteById(customerId);
    }

    @Override
    public void update(Integer customerId, AddCustomerRequest request) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new RuntimeException("Customer does not exist."));

        customer.setFirstName(request.getFirstName());
        customer.setMiddleName(request.getMiddleName());
        customer.setSurName(request.getSurName());
        customer.setAge(request.getAge());

        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getByAge(Integer age) {

        return customerRepository.findByAgeGreaterThan(age);

    }

    @Override
    public List<GetAllCustomerResponse> getLastName(String lastName) {

       // return customerRepository.findLastName(lastName);
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .filter(customer -> customer.getSurName().equals(lastName))
                .map(customer -> new GetAllCustomerResponse(customer.getFirstName(),
                        customer.getMiddleName(),
                        customer.getSurName(),
                        customer.getAge()))
                .toList();
    }

}

package com.tobeto.rentalcardemo.repository;

import com.tobeto.rentalcardemo.entity.Customer;
import com.tobeto.rentalcardemo.services.dto.customer.responses.GetAllCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Integer> {
    List<Customer> findByAgeGreaterThan(Integer age);

    @Query("Select new com.tobeto.rentalcardemo.services.dto.customer.responses.GetAllCustomerResponse(c.firstName,c.middleName,c.surName,c.age) " +
            "FROM Customer c WHERE c.surName = :lastName ")
    List<GetAllCustomerResponse> findLastName(String lastName);
}

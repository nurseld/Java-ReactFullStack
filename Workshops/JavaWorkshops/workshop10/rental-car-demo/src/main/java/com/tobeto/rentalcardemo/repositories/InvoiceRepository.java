package com.tobeto.rentalcardemo.repositories;

import com.tobeto.rentalcardemo.entities.concretes.Invoice;
import com.tobeto.rentalcardemo.services.dto.invoice.responses.GetAllInvoiceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findByTotalPriceGreaterThanEqual(double totalPrice);

    @Query("Select new com.tobeto.rentalcardemo.services.dto.invoice.responses.GetAllInvoiceResponse(i.totalPrice,i.paymentDateTime,i.paymentMethod) " +
            "FROM Invoice i WHERE i.paymentMethod = :paymentMethod")
    List<GetAllInvoiceResponse> findByPaymentMethod(String paymentMethod);
}

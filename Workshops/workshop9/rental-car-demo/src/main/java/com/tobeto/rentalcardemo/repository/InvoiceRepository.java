package com.tobeto.rentalcardemo.repository;

import com.tobeto.rentalcardemo.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository  extends JpaRepository<Invoice, Integer> {
}

package com.tobeto.rentalcardemo.services.abstracts;

import com.tobeto.rentalcardemo.entities.concretes.Invoice;
import com.tobeto.rentalcardemo.services.dto.invoice.requests.AddInvoiceRequest;
import com.tobeto.rentalcardemo.services.dto.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.rentalcardemo.services.dto.invoice.responses.AddInvoiceResponse;
import com.tobeto.rentalcardemo.services.dto.invoice.responses.GetAllInvoiceResponse;

import java.util.List;

public interface InvoiceService {

    AddInvoiceResponse add(AddInvoiceRequest request);
    List<GetAllInvoiceResponse> getAll();
    GetAllInvoiceResponse getById(Integer invoiceId);
    void delete(Integer invoiceId);
    void update(Integer invoiceId, UpdateInvoiceRequest request);
    List<Invoice> getGreaterTotalPrice(double totalPrice);
    List<GetAllInvoiceResponse> getPaymentMethod(String paymentMethod);
}

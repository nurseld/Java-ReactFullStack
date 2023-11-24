package com.tobeto.rentalcardemo.services.concretes;

import com.tobeto.rentalcardemo.entity.Invoice;
import com.tobeto.rentalcardemo.repository.InvoiceRepository;
import com.tobeto.rentalcardemo.services.abstracts.InvoiceService;
import com.tobeto.rentalcardemo.services.dto.invoice.requests.AddInvoiceRequest;
import com.tobeto.rentalcardemo.services.dto.invoice.responses.AddInvoiceResponse;
import com.tobeto.rentalcardemo.services.dto.invoice.responses.GetAllInvoiceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceManager implements InvoiceService {

    private final InvoiceRepository invoiceRepository;


    public InvoiceManager(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


    @Override
    public AddInvoiceResponse add(AddInvoiceRequest request) {

        Invoice invoice = new Invoice();

        invoice.setPaymentMethod(request.getPaymentMethod());
        invoice.setTotalPrice(request.getTotalPrice());
        invoice.setPaymentDateTime(request.getPaymentDateTime());

        Invoice savedInvoice = invoiceRepository.save(invoice);
        AddInvoiceResponse response = new AddInvoiceResponse();
        response.setId(savedInvoice.getInvoiceId());
        return response;
    }

    @Override
    public List<GetAllInvoiceResponse> getAll() {

        List<Invoice> invoiceList = invoiceRepository.findAll();
        List<GetAllInvoiceResponse> responses = new ArrayList<>();

        for (Invoice invoice:invoiceList) {

            GetAllInvoiceResponse response = new GetAllInvoiceResponse();

            response.setPaymentMethod(invoice.getPaymentMethod());
            response.setTotalPrice(invoice.getTotalPrice());
            response.setPaymentDateTime(invoice.getPaymentDateTime());

            responses.add(response);
        }
        return responses;
    }

    @Override
    public GetAllInvoiceResponse getById(Integer invoiceId) {

        Invoice invoiceInDb = invoiceRepository.findById(invoiceId)
                .orElseThrow(()-> new RuntimeException("Invoice does not exist."));

        GetAllInvoiceResponse response = new GetAllInvoiceResponse();

        response.setTotalPrice(invoiceInDb.getTotalPrice());
        response.setPaymentMethod(invoiceInDb.getPaymentMethod());
        response.setPaymentDateTime(invoiceInDb.getPaymentDateTime());

        return response;
    }

    @Override
    public void delete(Integer invoiceId) {

        invoiceRepository.deleteById(invoiceId);
    }

    @Override
    public void update(Integer invoiceId, AddInvoiceRequest request) {

        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(()-> new RuntimeException("Invoice does not exist."));

        invoice.setTotalPrice(request.getTotalPrice());
        invoice.setPaymentMethod(request.getPaymentMethod());
        invoice.setPaymentDateTime(request.getPaymentDateTime());


        invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getGreaterTotalPrice(double totalPrice) {

        return invoiceRepository.findByTotalPriceGreaterThanEqual(totalPrice) ;
    }

    @Override
    public List<GetAllInvoiceResponse> getPaymentMethod(String paymentMethod) {

        return invoiceRepository.findByPaymentMethod(paymentMethod) ;
    }
}

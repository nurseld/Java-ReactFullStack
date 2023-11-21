package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.dto.InvoiceRequest;
import com.tobeto.rentalcardemo.entity.Invoice;
import com.tobeto.rentalcardemo.repository.InvoiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceRepository invoiceRepository;

    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @PostMapping
    public String create(@RequestBody Invoice invoice){

        invoiceRepository.save(invoice);
        return "Invoice has been saved to DB.";
    }

    @GetMapping
    public List<Invoice> getAll(){

        return invoiceRepository.findAll();
    }

    @GetMapping("/{invoiceId}")
    public Invoice getById(@RequestParam Integer invoiceId){

        return invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice does not exist."));
    }

    @DeleteMapping("/{invoiceId}")
    public void delete(@RequestParam Integer invoiceId){

        invoiceRepository.deleteById(invoiceId);
    }

    @PutMapping
    public void update(@RequestBody InvoiceRequest request){

        Invoice invoiceInDb = invoiceRepository.findById(request.getInvoiceId())
                .orElseThrow(()-> new RuntimeException("Invoice does not exist."));

        invoiceInDb.setTotalPrice(request.getTotalPrice());
        invoiceInDb.setPaymentMethod(request.getPaymentMethod());
        invoiceInDb.setPaymentDateTime(request.getPaymentDateTime());

        invoiceRepository.save(invoiceInDb);
    }
}

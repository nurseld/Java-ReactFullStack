package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.entities.concretes.Invoice;
import com.tobeto.rentalcardemo.services.abstracts.InvoiceService;
import com.tobeto.rentalcardemo.services.dto.invoice.requests.AddInvoiceRequest;
import com.tobeto.rentalcardemo.services.dto.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.rentalcardemo.services.dto.invoice.responses.AddInvoiceResponse;
import com.tobeto.rentalcardemo.services.dto.invoice.responses.GetAllInvoiceResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public AddInvoiceResponse add(@RequestBody @Valid AddInvoiceRequest request){

        return invoiceService.add(request);

    }


    @GetMapping
    public List<GetAllInvoiceResponse> getAlL(){

        return invoiceService.getAll();

    }

    @GetMapping("/{invoiceId}")
    public GetAllInvoiceResponse getById(@PathVariable Integer invoiceId){

        return invoiceService.getById(invoiceId);

    }

    @DeleteMapping("/{invoiceId}")
    public void delete(@PathVariable Integer invoiceId){

        invoiceService.delete(invoiceId);

    }

    @PutMapping("/{invoiceId}")
    public void update(@PathVariable Integer invoiceId, @RequestBody @Valid UpdateInvoiceRequest request){

        invoiceService.update(invoiceId,request);

    }

    @GetMapping("totalPrice")
    public List<Invoice> getGreaterTotalPrice(@RequestParam double totalPrice){

        return invoiceService.getGreaterTotalPrice(totalPrice);

    }

    @GetMapping("paymentMethod")
    public List<GetAllInvoiceResponse> getPaymentMethod(@RequestParam String paymentMethod){

        return invoiceService.getPaymentMethod(paymentMethod);

    }
}

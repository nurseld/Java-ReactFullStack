package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.services.abstracts.InvoiceService;
import com.tobeto.rentalcardemo.services.dto.invoice.requests.AddInvoiceRequest;
import com.tobeto.rentalcardemo.services.dto.invoice.responses.AddInvoiceResponse;
import com.tobeto.rentalcardemo.services.dto.invoice.responses.GetAllInvoiceResponse;
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
    public AddInvoiceResponse add(@RequestBody AddInvoiceRequest request){

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
    public void update(@PathVariable Integer invoiceId, @RequestBody AddInvoiceRequest request){

        invoiceService.update(invoiceId,request);

    }
}

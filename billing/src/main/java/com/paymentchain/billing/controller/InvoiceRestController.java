package com.paymentchain.billing.controller;

import com.paymentchain.billing.common.InvoiceRequestMapper;
import com.paymentchain.billing.common.InvoiceResponseMapper;
import com.paymentchain.billing.dto.InvoiceRequest;
import com.paymentchain.billing.dto.InvoiceResponse;
import com.paymentchain.billing.entities.Invoice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.paymentchain.billing.respository.InvoiceRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Billing API", description = "This API serve all functionality for management Invoices")
@RestController
@RequestMapping("/billing")
public class InvoiceRestController {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceRequestMapper invoiceRequestMapper;

    @Autowired
    private InvoiceResponseMapper invoiceResponseMapper;

    @Operation(description = "Return all Invoices bundled into Response", summary = "Return 204 if no data found")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal Error") })
    @GetMapping()
    public List<InvoiceResponse> list() {
        List<Invoice> findAll = invoiceRepository.findAll();
        return invoiceResponseMapper.InvoiceListToInvoiceResponseList(findAll);
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable Long id) {
        Optional<Invoice> findById = invoiceRepository.findById(id);
        Invoice find = null;
        if (findById.isPresent()) {
            find = findById.get();
        }
        return find;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody InvoiceRequest input) {
        Invoice save = null;
        Optional<Invoice> findById = invoiceRepository.findById(Long.valueOf(id));
        if (findById.isPresent()) {
            save = invoiceRepository.save(findById.get());
        }
        return ResponseEntity.ok(save);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody InvoiceRequest input) {
        Invoice in = invoiceRequestMapper.InvoiceRequestToInvoice(input);
        Invoice save = invoiceRepository.save(in);
        InvoiceResponse ir = invoiceResponseMapper.InvoiceToInvoiceReponse(save);
        return ResponseEntity.ok(ir);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Invoice> findById = invoiceRepository.findById(Long.valueOf(id));
        if (findById.isPresent()) {
            invoiceRepository.delete(findById.get());
        }
        return ResponseEntity.ok().build();
    }

}

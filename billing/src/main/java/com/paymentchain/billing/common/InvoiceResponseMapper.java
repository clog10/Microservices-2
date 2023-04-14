package com.paymentchain.billing.common;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.paymentchain.billing.dto.InvoiceResponse;
import com.paymentchain.billing.entities.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceResponseMapper {

    @Mappings({
            @Mapping(source = "customerId", target = "customer"),
            @Mapping(source = "id", target = "invoiceId") })
    InvoiceResponse InvoiceToInvoiceReponse(Invoice source);

    List<InvoiceResponse> InvoiceListToInvoiceResponseList(List<Invoice> source);

    @InheritInverseConfiguration
    Invoice InvoiceResponseToInvoice(InvoiceResponse source);

    @InheritInverseConfiguration
    List<Invoice> InvoiceResponceListToInvoiceList(List<InvoiceResponse> source);

}

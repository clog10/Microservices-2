package com.paymentchain.billing.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "InvoiceRequest", description = "Model represent a Invoice on DataBase")
@Data
public class InvoiceRequest {

    @Schema(name = "customer", defaultValue = "1", description = "Unique Id of customer that represents the owner of invoice")
    private long customer;
    @Schema(name = "name", defaultValue = "Customer", description = "Name of customer that represents the owner of invoice")
    private String number;
    private String detail;
    private double amount;

}

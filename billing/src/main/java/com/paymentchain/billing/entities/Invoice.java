
package com.paymentchain.billing.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(name = "Invoice", description = "Model represent a Invoice on DataBase")
public class Invoice {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   @Schema(name = "customerId", defaultValue = "1", description = "Unique Id of customer that represents the owner of invoice")
   private long customerId;
   @Schema(name = "name", defaultValue = "Customer", description = "Name of customer that represents the owner of invoice")
   private String number;
   private String detail;
   private double amount;
}

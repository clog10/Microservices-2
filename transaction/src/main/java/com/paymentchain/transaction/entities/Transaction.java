
package com.paymentchain.transaction.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String reference;
  private String ibanAccount;
  private LocalDateTime date;
  private double amount;
  private double fee;
  private String description;
  private String status;
  private String channel;
}

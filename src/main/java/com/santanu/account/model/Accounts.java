package com.santanu.account.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Accounts {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    private long accountNumber;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "branch_address")
    private String branchAddress;
    @Column(name = "create_dt")
    private LocalDate createDt;
}

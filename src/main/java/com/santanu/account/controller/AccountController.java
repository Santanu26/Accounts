package com.santanu.account.controller;

import com.santanu.account.model.Account;
import com.santanu.account.model.Customer;
import com.santanu.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/myAccount")
    public Account getAccountDetails(@RequestBody @Validated Customer customer) {

        return accountService.findByCustomerId(customer.getCustomerId()).orElse(null);
    }
}

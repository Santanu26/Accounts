package com.santanu.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.santanu.account.config.AccountServiceConfig;
import com.santanu.account.model.Account;
import com.santanu.account.model.Customer;
import com.santanu.account.model.Properties;
import com.santanu.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    private final AccountServiceConfig serviceConfig;

    @GetMapping("/myAccount")
    public Account getAccountDetails(@RequestBody @Validated Customer customer) {

        return accountService.findByCustomerId(customer.getCustomerId()).orElse(null);
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.findAll().orElse(null);
    }

    @GetMapping("/account/properties")
    public String getAccountProperties() throws IOException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = Properties.builder()
                .msg(serviceConfig.getMsg())
                .buildVersion(serviceConfig.getBuildVersion())
                .mailDetails(serviceConfig.getMailDetails())
                .activeBranches(serviceConfig.getActiveBranches()).build();

        return objectWriter.writeValueAsString(properties);
    }
}

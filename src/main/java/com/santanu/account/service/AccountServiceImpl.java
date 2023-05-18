package com.santanu.account.service;

import com.santanu.account.model.Account;
import com.santanu.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {


    private final AccountRepository accountRepository;

    @Override
    public Optional<Account> findByCustomerId(int customerId) {
        return accountRepository.findByCustomerId(customerId);
    }
}

package com.nwg.boa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nwg.boa.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findBycustomerid(String id);
    //List<Account> findByTitleContaining(String title);
    Account save(Account account);
}


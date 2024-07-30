package com.nwg.boa.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nwg.boa.model.Account;
import com.nwg.boa.repository.AccountRepository;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;


    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") String id) {
        Account accountData = accountRepository.findBycustomerid(id);
        System.out.println(accountData);
        if (accountData != null) {
            return new ResponseEntity<>(accountData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/makeapayment")
    public ResponseEntity<Account> makeapayment(@RequestBody Account account) {
        System.out.println(account.getCustomerid());
        Account accountData = accountRepository.findBycustomerid(account.getCustomerid());
        System.out.println(accountData);
        if (accountData != null) {
            System.out.println(accountData.isSmallsavings());

            if(accountData.isSmallsavings())
           {
                //            if(accountData.getSmallsavingsbalance() != null)
//                {
//                    accountData.setSmallsavingsbalance(0.0);
//                }

                if (account.getTransactionamt() >=10 &&  account.getTransactionamt() <= 50)
                {
                    double savingAmt = accountData.getSmallsavingsperc1()/100 * account.getTransactionamt();
                    double totalAmt = account.getTransactionamt() + savingAmt;
                    accountData.setSmallsavingsbalance(accountData.getSmallsavingsbalance() + savingAmt);
                    accountData.setSavingsbalance(accountData.getSavingsbalance() - totalAmt);
                }
                else if (account.getTransactionamt() >50 &&  account.getTransactionamt() <=100)
                {
                    double savingAmt = (long) ((double)accountData.getSmallsavingsperc2()/100 * account.getTransactionamt());
                    double totalAmt = account.getTransactionamt() + savingAmt;
                    accountData.setSmallsavingsbalance(accountData.getSmallsavingsbalance() + savingAmt);
                    accountData.setSavingsbalance(accountData.getSavingsbalance() - totalAmt);
                }
                else
                {
                    accountData.setSavingsbalance(accountData.getSavingsbalance() - account.getTransactionamt());
                }
            }
            else
            {
                accountData.setSavingsbalance(accountData.getSavingsbalance() - account.getTransactionamt());
            }
            return new ResponseEntity<>(accountRepository.save(accountData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/smallsavingaccount/{id}")
    public ResponseEntity<Account> updateSmallSavings(@PathVariable("id") String id, @RequestBody Account account) {
        Account accountData = accountRepository.findBycustomerid(id);
        System.out.println(accountData);
        if (accountData != null) {
            accountData.setSmallsavings(account.isSmallsavings());
            System.out.println("adf"+account.getTargetgoal());
            if(account.isSmallsavings())
            {
                accountData.setSmallsavingsperc1(account.getSmallsavingsperc1());
                accountData.setSmallsavingsperc2(account.getSmallsavingsperc2());
                accountData.setTargetgoal(account.getTargetgoal());
            }

            accountData.setSmallsavingsacc("****9870");
            return new ResponseEntity<>(accountRepository.save(accountData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/smallsavingaccount/deactivate/{id}")
    public ResponseEntity<Account> closeSmallSavings(@PathVariable("id") String id, @RequestBody Account account) {
        Account accountData = accountRepository.findBycustomerid(id);

        if (accountData != null) {
            accountData.setSmallsavings(false);
            accountData.setSmallsavingsacc("");
            accountData.setSavingsbalance(accountData.getSavingsbalance() + accountData.getSmallsavingsbalance());
            accountData.setSmallsavingsbalance(0);
            accountData.setSmallsavingsperc1(0);
            accountData.setSmallsavingsperc2(0);
            accountData.setTargetgoal(0);
            return new ResponseEntity<>(accountRepository.save(accountData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
/*
    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            tutorialRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        try {
            List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

}


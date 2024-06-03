package com.my_springboot_project.bankingapp.controller;

import com.my_springboot_project.bankingapp.dto.AccountDto;
import com.my_springboot_project.bankingapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {


    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    //Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // GET Account by Id
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){

        AccountDto accountDto =  accountService.getAccountById(id);

        return  ResponseEntity.ok(accountDto);
    }

    //Deposit Rest API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String, Double> request){

      Double amount = request.get("amount");
      AccountDto accountDto =  accountService.deposit(id, amount);

      return ResponseEntity.ok(accountDto);
    }

    //Withdraw REST API

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String, Double> request){

        Double amount = request.get("amount");
        AccountDto accountDto =  accountService.withdraw(id, amount);

        return ResponseEntity.ok(accountDto);
    }

    // GET all Accounts
    @GetMapping
    public  ResponseEntity<List<AccountDto>> getAllAccounts(){
      List<AccountDto> accounts =  accountService.getAllAccounts();

        return ResponseEntity.ok(accounts);


    }


    // DELETE account by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){

        accountService.deleteAccount(id);

        return  ResponseEntity.ok("Account is deleted successfully");
    }


}

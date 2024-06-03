package com.my_springboot_project.bankingapp.repository;

import com.my_springboot_project.bankingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}

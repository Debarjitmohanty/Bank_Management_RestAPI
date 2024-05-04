package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}

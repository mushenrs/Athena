package me.mushen.athena.springdata.es.service;

import me.mushen.athena.springdata.es.document.BankAccount;

import java.util.Optional;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-11-08
 */
public interface IBankAccountService {

    Optional<BankAccount> getBankAccountByFirstname(String firstname) throws Exception;
}

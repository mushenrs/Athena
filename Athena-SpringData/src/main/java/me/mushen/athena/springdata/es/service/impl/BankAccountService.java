package me.mushen.athena.springdata.es.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.mushen.athena.springdata.es.document.BankAccount;
import me.mushen.athena.springdata.es.repository.BankAccountRepository;
import me.mushen.athena.springdata.es.service.IBankAccountService;
import me.mushen.athena.springdata.util.ObjectMappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-11-08
 */
@Service
public class BankAccountService implements IBankAccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountService.class);

    private static final ObjectMapper mapper = ObjectMappers.mapper();

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public Optional<BankAccount> getBankAccountByFirstname(String firstname) throws Exception {
        Optional<BankAccount> bankAccountOpl = bankAccountRepository.findByFirstname(firstname);

        BankAccount bankAccount = bankAccountRepository.findOne(30L);
        System.out.println("==== " + mapper.writeValueAsString(bankAccount) + " ====");
        if(bankAccountOpl.isPresent()){
            System.out.println(mapper.writeValueAsString(bankAccountOpl.get()));
        }else {
            System.out.println("NULL");
        }
        return bankAccountOpl;
    }
}

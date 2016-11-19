package me.mushen.athena.springdata.es.repository;

import me.mushen.athena.springdata.es.document.BankAccount;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-11-08
 */
public interface BankAccountRepository extends ElasticsearchRepository<BankAccount, Long> {

    Optional<BankAccount> findByFirstname(String firstName);
}

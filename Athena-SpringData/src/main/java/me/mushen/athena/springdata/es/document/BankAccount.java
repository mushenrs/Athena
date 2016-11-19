package me.mushen.athena.springdata.es.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-11-08
 */
@Document(
        indexName = "bank",
        type = "account"
)
public class BankAccount {
    @Id
    @JsonProperty("account_number")
    public Long accountNumber;

    public Long balance;

    public String firstname;

    public String lastname;

    public Integer age;

    public String gender;

    public String address;

    public String employer;

    public String email;

    public String city;

    public String state;
    @Version
    public Long version;
}

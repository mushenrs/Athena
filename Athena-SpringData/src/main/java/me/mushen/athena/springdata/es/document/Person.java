package me.mushen.athena.springdata.es.document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-11-09
 */
@Document(
        indexName = "person",
        type = "user",
        shards = 1,
        replicas = 0,
        indexStoreType = "memory",
        refreshInterval = "-1"
)
public class Person {
    @Id
    public Integer id;

    public String name;

    @Field(
            type = FieldType.Nested
    )
    public List<Car> carList = new ArrayList<>();

    @Version
    public Long version;

    @JsonCreator
    public Person(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public static class Car {
        public String name;
        public String model;

        public Car(){}

        public Car(String name, String model) {
            this.name = name;
            this.model = model;
        }
    }
}



package me.mushen.athena.springdata.es.repository;

import me.mushen.athena.springdata.es.document.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-11-09
 */
public interface PersonRepository extends ElasticsearchRepository<Person, Integer> {
}

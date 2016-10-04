package me.mushen.athena.springdata.es.repository;

import me.mushen.athena.springdata.es.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-02
 */
public interface SampleBookRepository extends ElasticsearchRepository<Book, String> {
    Page<Book> findByNameAndPrice(String name, Integer price, Pageable pageable);
    Page<Book> findByNameOrPrice(String name, Integer price, Pageable pageable);
    Page<Book> findByName(String name, Pageable pageable);
}

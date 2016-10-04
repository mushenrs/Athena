package me.mushen.athena.springdata.es;

import me.mushen.athena.springdata.es.entity.Book;
import me.mushen.athena.springdata.es.repository.SampleBookRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.Arrays;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-02
 */
public class BookESMain {

    public static void main(String[] args){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/context/elasticsearch-context.xml");

        SampleBookRepository repository = ctx.getBean(SampleBookRepository.class);

        ElasticsearchTemplate template = ctx.getBean(ElasticsearchTemplate.class);

        // delete all data
        repository.deleteAll();
        // save entity
        Book book = new Book("123456", "Spring Data Elasticsearch", System.currentTimeMillis());
        repository.save(book);
        Book indexedBook = repository.findOne(book.getId());
        System.out.println(indexedBook);
        //
        Book book1 = new Book(RandomStringUtils.random(5), "Spring Data", System.currentTimeMillis());
        Book book2 = new Book(RandomStringUtils.random(5), "Spring Data Elasticsearch", System.currentTimeMillis());
        repository.save(Arrays.asList(book1, book2));
        Book indexedBook1 = repository.findOne(book1.getId());
        System.out.println(indexedBook1);
        Book indexedBook2 = repository.findOne(book2.getId());
        System.out.println(indexedBook2);
    }

}

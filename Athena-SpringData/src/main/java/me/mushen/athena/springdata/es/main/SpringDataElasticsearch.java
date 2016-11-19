package me.mushen.athena.springdata.es.main;

import me.mushen.athena.springdata.es.config.ApplicationESConfiguration;
import me.mushen.athena.springdata.es.repository.PersonRepository;
import me.mushen.athena.springdata.es.service.IBankAccountService;
import me.mushen.athena.springdata.es.service.IPersonService;
import me.mushen.athena.springdata.es.service.impl.BankAccountService;
import me.mushen.athena.springdata.es.service.impl.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-11-08
 */
public class SpringDataElasticsearch {

    public static void main(String[] args) throws Exception {

        // use with java configuration
        AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext(ApplicationESConfiguration.class);
        mainWithJavaConfiguration(actx);

        // use with xml configuration
//        ClassPathXmlApplicationContext xctx = new ClassPathXmlApplicationContext("classpath:/context/elasticsearch-context.xml");
//        mainWithXmlConfiguration(xctx);
    }

    private static void mainWithJavaConfiguration(AnnotationConfigApplicationContext ctx) throws Exception {
        // PersonService
        IPersonService personService = ctx.getBean(PersonService.class);
        // PersonRepository
        PersonRepository personRepository = ctx.getBean(PersonRepository.class);
        ElasticsearchTemplate elasticsearchTemplate = ctx.getBean(ElasticsearchTemplate.class);
//        elasticsearchTemplate.deleteIndex("person");
//        personRepository.deleteAll();
        personService.savePersonByInit();
    }

    private static void mainWithXmlConfiguration(ClassPathXmlApplicationContext ctx) throws Exception {
        IBankAccountService bankAccountService = ctx.getBean(BankAccountService.class);
        bankAccountService.getBankAccountByFirstname("Darla");
    }
}

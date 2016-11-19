package me.mushen.athena.springdata.es.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.mushen.athena.springdata.es.build.PersonBuilder;
import me.mushen.athena.springdata.es.document.Person;
import me.mushen.athena.springdata.es.repository.PersonRepository;
import me.mushen.athena.springdata.es.service.IPersonService;
import me.mushen.athena.springdata.util.ObjectMappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-11-09
 */
@Service
public class PersonService implements IPersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    private static final ObjectMapper mapper = ObjectMappers.mapper();

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void savePersonByInit() throws Exception {
        for(int i = 1; i <= 500; i++){
            PersonBuilder personBuilder = new PersonBuilder(i);
            personBuilder.setName("Misaka-" + (i < 10 ? "00" : (i < 100 ? "0" : "")) + i);
            personBuilder.setVersion(System.currentTimeMillis());
            personBuilder.setCar("BMW-" + (i < 10 ? "00" : (i < 100 ? "0" : "")) + i, "Mikoto-" + (i < 10 ? "00" : (i < 100 ? "0" : "")) + i);

            Person savedPerson = personRepository.index(personBuilder.build());
            LOGGER.info("Init Person[{}] to Elasticsearch[index: person, type: user]", mapper.writeValueAsString(savedPerson));
        }
    }
}

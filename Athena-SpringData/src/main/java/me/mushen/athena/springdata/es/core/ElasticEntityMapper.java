package me.mushen.athena.springdata.es.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.elasticsearch.core.EntityMapper;
import org.springframework.data.elasticsearch.core.geo.CustomGeoModule;

import java.io.IOException;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-11-09
 */
public class ElasticEntityMapper implements EntityMapper {

    private ObjectMapper objectMapper;

    public ElasticEntityMapper(){
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.registerModule(new CustomGeoModule());
    }

    public ElasticEntityMapper(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public String mapToString(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    @Override
    public <T> T mapToObject(String source, Class<T> clazz) throws IOException {
        return objectMapper.readValue(source, clazz);
    }
}

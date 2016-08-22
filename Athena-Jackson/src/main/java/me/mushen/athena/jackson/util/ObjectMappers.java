package me.mushen.athena.jackson.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import me.mushen.athena.jackson.pojo.java2json.Album;

import java.text.SimpleDateFormat;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-18
 */
public class ObjectMappers {

    public static ObjectMapper defaultObjectMapperForAlbum() {
        ObjectMapper mapper = new ObjectMapper();
        // pretty out
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        // map key order
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        // date: yyyy-MM-dd
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(outputFormat);
        // override JSON property
        mapper.setPropertyNamingStrategy(new PropertyNamingStrategy(){
            @Override
            public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName){
                if(field.getFullName().equals("me.mushen.athena.spring.jackson.pojo.java2json.Artist#name")){
                    return "Artist-Name";
                }
                return super.nameForField(config, field, defaultName);
            }
            @Override
            public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName){
                if(method.getAnnotated().getDeclaringClass().equals(Album.class) && defaultName.equals("title")){
                    return "Album-Title";
                }
                return super.nameForGetterMethod(config, method, defaultName);
            }
        });
        // ignore properties that are empty
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        return mapper;
    }
}

package me.mushen.athena.springdata.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

/**
 * @Desc Jackson ObjectMapper 工具类
 * @Author Remilia
 * @Create 2016-09-12
 */
public final class ObjectMappers {

    public static ObjectMapper defaultObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        // date: yyyy-MM-dd HH:mm:ss
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(outputFormat);
        // Determines whether encountering of unknown properties or not.
        // unknown properties means: ones that do not map to a property,
        // and there is no "any setter" or handler that can handle it
        // Feature is enabled by default
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return mapper;
    }

    public static ObjectMapper mapper(){
        ObjectMapper mapper = new ObjectMapper();
        // date: yyyy-MM-dd HH:mm:ss
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(outputFormat);
        // Determines whether encountering of unknown properties or not.
        // unknown properties means: ones that do not map to a property,
        // and there is no "any setter" or handler that can handle it
        // Feature is enabled by default
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return mapper;
    }
}

package me.mushen.athena.springmvc.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-23
 */
@Configuration
@ComponentScan(
        basePackages = {"me.mushen.athena.springmvc.spittr"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        }
)
public class RootConfig {

}

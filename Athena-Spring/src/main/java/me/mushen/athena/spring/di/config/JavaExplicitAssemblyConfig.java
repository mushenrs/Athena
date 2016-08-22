package me.mushen.athena.spring.di.config;

import me.mushen.athena.spring.di.bean.CDPlayer;
import me.mushen.athena.spring.di.bean.ICompactDisc;
import me.mushen.athena.spring.di.bean.IMediaPlayer;
import me.mushen.athena.spring.di.bean.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-07-16
 */
@Configuration
public class JavaExplicitAssemblyConfig {

    @Bean
//    @Bean(name = "sgtPeppers")
    public ICompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    @Bean
    public IMediaPlayer cdPlayer(){
        return new CDPlayer(sgtPeppers());
    }
}

package me.mushen.athena.di.config;

import me.mushen.athena.di.bean.CDPlayer;
import me.mushen.athena.di.bean.ICompactDisc;
import me.mushen.athena.di.bean.IMediaPlayer;
import me.mushen.athena.di.bean.SgtPeppers;
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

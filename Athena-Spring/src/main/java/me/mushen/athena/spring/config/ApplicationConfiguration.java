package me.mushen.athena.spring.config;

import me.mushen.athena.spring.bean.CDPlayer;
import me.mushen.athena.spring.bean.CompactDisc;
import me.mushen.athena.spring.bean.MediaPlayer;
import me.mushen.athena.spring.bean.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-08
 */
@Configuration
//@ComponentScan(basePackages = {"me.mushen.athena.spring.bean"}) // 自动装配
public class ApplicationConfiguration {

    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

//    @Bean
//    public MediaPlayer cdPlayer(){
//        return new CDPlayer(sgtPeppers());
//    }

    @Bean
    public MediaPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}

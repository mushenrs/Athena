package me.mushen.athena.spring.main;

import me.mushen.athena.spring.bean.CDPlayer;
import me.mushen.athena.spring.bean.CompactDisc;
import me.mushen.athena.spring.bean.MediaPlayer;
import me.mushen.athena.spring.bean.SgtPeppers;
import me.mushen.athena.spring.config.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-08
 */
public class DIMainWithJava {

    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        CompactDisc cd = ctx.getBean("sgtPeppers", SgtPeppers.class);
        cd.play();

        MediaPlayer mediaPlayer = ctx.getBean(CDPlayer.class);
        mediaPlayer.play();
    }
}

package me.mushen.athena.spring.main;

import me.mushen.athena.spring.bean.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-08
 */
public class DIMainWithXML {

    public static void main(String[] args){
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath:/configuration/application-context-di.xml");

        CompactDisc cd = ctx.getBean("sgtPeppers", SgtPeppers.class);
        cd.play();
        CompactDisc cd2 = ctx.getBean("blackDisc", BlackDisc.class);
        cd2.play();

        MediaPlayer mediaPlayer = ctx.getBean(CDPlayer.class);
        mediaPlayer.play();
    }
}

package me.mushen.athena.spring.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-07-16
 */
public class DIMain {

    public static void main(String[] args){
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaComponentScanConfig.class);
//
//        ICompactDisc compactDisc = ctx.getBean(SgtPeppers.class);
//        compactDisc.play();

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/application-context-di.xml");
    }
}

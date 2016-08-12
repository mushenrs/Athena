package me.mushen.athena.di;

import me.mushen.athena.di.bean.ICompactDisc;
import me.mushen.athena.di.bean.SgtPeppers;
import me.mushen.athena.di.config.JavaComponentScanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-07-16
 */
public class DIMain {

    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaComponentScanConfig.class);

        ICompactDisc compactDisc = ctx.getBean(SgtPeppers.class);
        compactDisc.play();
    }
}

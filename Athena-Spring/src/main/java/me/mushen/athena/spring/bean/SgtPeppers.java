package me.mushen.athena.spring.bean;

import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-08
 */
@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Play " + title + " by " + artist);
    }
}

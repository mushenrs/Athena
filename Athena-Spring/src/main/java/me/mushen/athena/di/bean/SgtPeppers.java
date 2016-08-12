package me.mushen.athena.di.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-07-16
 */
@Component
public class SgtPeppers implements ICompactDisc {
    private static final Logger LOGGER = LoggerFactory.getLogger(SgtPeppers.class);

    private static final String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private static final String artist = "The Beatles";

    @Override
    public void play() {
        LOGGER.info("Playing " + title + " by " + artist);
        System.out.println("Playing " + title + " by " + artist);
    }
}

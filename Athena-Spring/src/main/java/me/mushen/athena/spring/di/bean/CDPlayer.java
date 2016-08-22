package me.mushen.athena.spring.di.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-07-16
 */
@Component
public class CDPlayer implements IMediaPlayer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CDPlayer.class);
    @Autowired
    private ICompactDisc compactDisc;

    public CDPlayer() {
    }

    public CDPlayer(ICompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }
}

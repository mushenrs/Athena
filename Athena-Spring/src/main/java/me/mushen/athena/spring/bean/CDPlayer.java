package me.mushen.athena.spring.bean;

import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-08
 */
@Component
public class CDPlayer implements MediaPlayer {
//    @Autowired
    private CompactDisc cd;

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}

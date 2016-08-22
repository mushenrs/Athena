package me.mushen.athena.spring.di;

import me.mushen.athena.spring.di.bean.ICompactDisc;
import me.mushen.athena.spring.di.bean.IMediaPlayer;
import me.mushen.athena.spring.di.config.JavaComponentScanConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-07-16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JavaComponentScanConfig.class}) // 组件扫描
public class CDPlayerTest {
    @Rule
    public final SystemOutRule rule = new SystemOutRule().enableLog();

    @Autowired
    private IMediaPlayer mediaPlayer;
    @Autowired
    private ICompactDisc compactDisc;

    @Test
    public void testCDShouldNotBeNull(){
        assertNotNull(compactDisc);
    }

    @Test
    public void testCDPlayerPlay(){
        mediaPlayer.play();
        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n", rule.getLog());
    }
}

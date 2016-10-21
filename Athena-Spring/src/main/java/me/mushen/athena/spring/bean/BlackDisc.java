package me.mushen.athena.spring.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-09
 */
public class BlackDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;

    public BlackDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public BlackDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for(String track : tracks){
            System.out.println("-Track: " + track);
        }
    }
}

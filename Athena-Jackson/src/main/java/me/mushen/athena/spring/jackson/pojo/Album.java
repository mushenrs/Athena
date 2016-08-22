package me.mushen.athena.spring.jackson.pojo;

import java.util.*;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-17
 */
public class Album {
    // album title
    private String title;
    // the press releases or album reviews.
    private String[] links;
    // a List of Songs
    private List<String> songs;
    // artist
    private Artist artist;
    // a map of musicians and the instrument they play
    private Map<String, String> musicians;

    // Getters && Setters
    public Album(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getLinks() {
        return links;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Map<String, String> getMusicians() {
        return Collections.unmodifiableMap(musicians);
    }

    public void setMusicians(Map<String, String> musicians) {
        this.musicians = musicians;
    }
}

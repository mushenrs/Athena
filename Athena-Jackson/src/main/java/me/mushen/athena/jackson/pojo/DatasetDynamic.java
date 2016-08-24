package me.mushen.athena.jackson.pojo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-23
 */
public class DatasetDynamic {
    @JsonProperty("album_id")
    private String albumId;
    @JsonProperty("album_title")
    private String albumTitle;

    private Map<String, Object> otherProperties = new HashMap<>();

    @JsonCreator
    public DatasetDynamic(@JsonProperty("album_id") String albumId,
                          @JsonProperty("album_title") String albumTitle) {
        this.albumId = albumId;
        this.albumTitle = albumTitle;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public Object getProperty(String name){
        return otherProperties.get(name);
    }

    @JsonAnyGetter
    public Map<String, Object> getOtherProperties() {
        return otherProperties;
    }

    @JsonAnySetter
    public void setProperty(String name, Object value) {
        this.otherProperties.put(name, value);
    }
}

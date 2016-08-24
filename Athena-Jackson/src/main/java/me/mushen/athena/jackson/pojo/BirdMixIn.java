package me.mushen.athena.jackson.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-24
 */
public abstract class BirdMixIn {
    public BirdMixIn(@JsonProperty("name") String name){
    }

    @JsonProperty("bird_sound")
    private String sound;

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    @JsonProperty("bird_habitat")
    public abstract String getHabitat();
}

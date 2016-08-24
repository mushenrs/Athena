package me.mushen.athena.jackson.pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-23
 */
public class Baguette extends Bread {

    @JsonCreator
    public Baguette(@JsonProperty("name") String name){
        super.name = name;
    }

    @Override
    public String toString() {
        return "Baguette: " + name;
    }
}

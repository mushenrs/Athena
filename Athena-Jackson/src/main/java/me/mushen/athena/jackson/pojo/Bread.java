package me.mushen.athena.jackson.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-23
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({ @JsonSubTypes.Type(value = Baguette.class, name = "baguette"),
                @JsonSubTypes.Type(value = ToastBread.class, name = "toastbread")})
public abstract class Bread {
    @JsonProperty("name")
    protected String name;

    @Override
    public String toString() {
        return "Bread: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

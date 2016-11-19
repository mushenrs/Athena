package me.mushen.athena.springmvc.spittr.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-30
 */
public class Spittle {
    private final Long id;

    private final String message;

    private final Date time;

    private Double latitude;

    private Double longitude;

    public Spittle(Long id, String message, Date time) {
        this(id, message, time, 0.0, 0.0);
    }

    public Spittle(Long id, String message, Date time, Double latitude, Double longitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object that){
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}

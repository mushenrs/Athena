package me.mushen.athena.jackson.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-18
 */
public class Artist {
    public String name;
    public Date birthDate;
    public int age;
    public String homeTown;
    public List<String> awardsWon = new ArrayList<String>();
}

package me.mushen.athena.jackson.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.mushen.athena.jackson.pojo.Bird;
import me.mushen.athena.jackson.pojo.BirdMixIn;

import java.io.IOException;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-24
 */
public class MixAnnotationExample {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(Bird.class, BirdMixIn.class);

        Bird bird = new Bird("scarlet Ibis");
        bird.setSound("eee");
        bird.setHabitat("water");

        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, bird);
    }
}

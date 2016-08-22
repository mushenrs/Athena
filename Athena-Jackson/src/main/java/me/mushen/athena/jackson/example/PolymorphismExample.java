package me.mushen.athena.jackson.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.mushen.athena.jackson.pojo.Animal;
import me.mushen.athena.jackson.pojo.Elephant;
import me.mushen.athena.jackson.pojo.Lion;
import me.mushen.athena.jackson.pojo.Zoo;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-22
 */
public class PolymorphismExample {
    private final static String outputFile = "/tmp/zoo.json";

    public static void main(String[] args) throws IOException {
        PolymorphismExample example = new PolymorphismExample();
        // serialize
        example.serialize();
        // deSerialize
        example.deSerialize();
    }

    private void serialize() throws IOException {
        // let start creating the zoo
        Zoo zoo = new Zoo("Samba Wild Park", "Paz");
        Lion lion = new Lion("Simba");
        Elephant elephant = new Elephant("Manny");
        List<Animal> animals = new ArrayList<>();
        animals.add(lion);
        animals.add(elephant);
        zoo.setAnimals(animals);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(new File(outputFile)), zoo);
    }

    private void deSerialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Zoo zoo = mapper.readValue(FileUtils.readFileToByteArray(new File(outputFile)), Zoo.class);
        System.out.println(zoo);
    }
}

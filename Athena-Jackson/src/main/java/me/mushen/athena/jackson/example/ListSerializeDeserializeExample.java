package me.mushen.athena.jackson.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.mushen.athena.jackson.pojo.Baguette;
import me.mushen.athena.jackson.pojo.Bakeshop;
import me.mushen.athena.jackson.pojo.ToastBread;

import java.io.IOException;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-23
 */
public class ListSerializeDeserializeExample {

    public static void main(String[] args) throws IOException {
        ListSerializeDeserializeExample example = new ListSerializeDeserializeExample();
        // Serialize Object which has a list property
        example.serializeListInObject();
        // Deserialize Object which has a list property
        example.deserializeListInObject();
    }

    private void serializeListInObject() throws IOException {
        Bakeshop bakeshop = new Bakeshop("Koumakan", "Gensokyo");
        bakeshop.addBread(new ToastBread("toast bread"));
        bakeshop.addBread(new Baguette("baguette"));
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(bakeshop);
        System.out.println("JSON: " + json);
    }

    private void deserializeListInObject() throws IOException {
        String json = "{\"name\":\"Koumakan\",\"address\":\"Gensokyo\",\"breads\":[{\"@class\":\"me.mushen.athena.jackson.pojo.ToastBread\",\"name\":\"toast bread\"},{\"@class\":\"me.mushen.athena.jackson.pojo.Baguette\",\"name\":\"baguette\"}]}";
        ObjectMapper mapper = new ObjectMapper();
        Bakeshop bakeshop = mapper.readValue(json, Bakeshop.class);
        System.out.println("Bakeshop: " + bakeshop);
    }
}

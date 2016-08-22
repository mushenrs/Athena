package me.mushen.athena.jackson.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import me.mushen.athena.jackson.util.ObjectMappers;
import me.mushen.athena.jackson.pojo.java2json.Album;
import me.mushen.athena.jackson.pojo.java2json.Artist;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-18
 */
public class Java2JsonExample {

    public static void main(String[] args) throws Exception {
        Java2JsonExample example = new Java2JsonExample();
        // create JSON from a Java Object
        example.createJsonByJavaObject();
        // create JSON from a JsonNode Tree
        example.createJsonByJsonNodeTree();
    }

    private void createJsonByJavaObject() throws ParseException, IOException {
        ObjectMapper mapper = ObjectMappers.defaultObjectMapperForAlbum();

        Album album = new Album("Kind Of Blue");

        album.setLinks(new String[]{"link1", "link2"});

        List<String> songs = new ArrayList<>();
        Collections.addAll(songs, "So What", "Flamenco Sketches", "Freddie Freeloader");
        album.setSongs(songs);

        Artist artist = new Artist();
        artist.name = "Miles Davis";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        artist.birthDate = format.parse("1926-05-26");
        album.setArtist(artist);

        Map<String, String> musicians = new HashMap<>();
        musicians.put("Miles Davis", "Trumpet, Band leader");
        musicians.put("Julian Adderley", "Alto Saxophone");
        musicians.put("Paul Chambers", "double bass");
        album.setMusicians(musicians);

        System.out.println(mapper.writeValueAsString(album));
        mapper.writeValue(System.out, album);
    }

    private void createJsonByJsonNodeTree() throws IOException {
        // Create the node factory that gives us nodes.
        JsonNodeFactory factory = new JsonNodeFactory(false);
        // create a json factory to write the treenode as json.
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator generator = jsonFactory.createGenerator(System.out);
        ObjectMapper mapper = new ObjectMapper();
        // pretty out
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        // the root node - album
        ObjectNode album = factory.objectNode();
        album.put("Album-Title", "Kind Of Blue");

        ArrayNode links = factory.arrayNode();
        links.add("link1").add("link2");
        album.set("links", links);

        ObjectNode artist = factory.objectNode();
        artist.put("Artist-Name", "Miles Davis");
        artist.put("birthDate", "26 May 1926");
        album.set("artist", artist);

        ObjectNode musicians = factory.objectNode();
        musicians.put("Julian Adderley", "Alto Saxophone");
        musicians.put("Miles Davis", "Trumpet, Band leader");
        album.set("musicians", musicians);

        mapper.writeTree(generator, album);
    }

}

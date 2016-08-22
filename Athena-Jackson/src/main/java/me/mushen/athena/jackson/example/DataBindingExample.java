package me.mushen.athena.jackson.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.mushen.athena.jackson.pojo.json2java.Albums;
import me.mushen.athena.jackson.pojo.json2java.AlbumsFilter;
import me.mushen.athena.jackson.pojo.json2java.Dataset;
import me.mushen.athena.jackson.pojo.json2java.DatasetFilter;

import java.io.InputStream;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-22
 */
public class DataBindingExample{

    public static void main(String[] args) {
        DataBindingExample example = new DataBindingExample();
        // conversion JSON to Java Object
        example.convJsonToJavaObject();
        // conversion JSON to Java Object with @JsonIgnoreProperties and @JsonIgnore
        example.convJsonToJavaObjectWithFilterAnnotation();
    }

    private void convJsonToJavaObject() {
        try(InputStream is = this.getClass().getResourceAsStream("/albums4r.json")){
            ObjectMapper mapper = new ObjectMapper();
            // determines whether encountering of unknown properties; enabled by default
            // This setting only takes effect after all other handling methods for unknown properties have been tried,
            // and property remains unhandled.
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            Albums albums = mapper.readValue(is, Albums.class);
            Dataset[] datasets = albums.getDataset();
            for (Dataset dataset : datasets) {
                System.out.println(dataset.getAlbum_title());
            }
        }catch(Exception e){
            System.err.println("Conversion JSON to Java Object, Error: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    private void convJsonToJavaObjectWithFilterAnnotation(){
        try(InputStream is = this.getClass().getResourceAsStream("/albums4r.json")){
            ObjectMapper mapper = new ObjectMapper();
            // determines whether encountering of unknown properties; enabled by default
            // This setting only takes effect after all other handling methods for unknown properties have been tried,
            // and property remains unhandled.
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            AlbumsFilter albums = mapper.readValue(is, AlbumsFilter.class);
            System.out.println(albums.total_pages);
            System.out.println(albums.getTitle());
            for (DatasetFilter dataset : albums.getDatasetFilter()) {
                System.out.println("Properties -> album_comments: " + dataset.getAlbum_comments());
                System.out.println("Properties -> album_id: " + dataset.getAlbum_id());
                System.out.println("Properties -> album_title: " + dataset.getAlbum_title());
                System.out.println("AnyGetter -> album_images: " + dataset.get("album_images"));
                System.out.println("AnyGetter -> tags: " + dataset.get("tags"));
                System.out.println("AnyGetter -> album_listens: " + dataset.get("album_listens"));
                System.out.println("AnyGetter -> album_comments: " + dataset.get("album_comments"));
                System.out.println("AnyGetter -> album_id: " + dataset.get("album_id"));
                System.out.println("AnyGetter -> album_title: " + dataset.get("album_title"));
                break;
            }
        }catch(Exception e){
            System.err.println("Conversion JSON to Java Object with Filter, Error: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}

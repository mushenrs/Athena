package me.mushen.athena.jackson.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.mushen.athena.jackson.pojo.AlbumDynamic;
import me.mushen.athena.jackson.pojo.DatasetDynamic;

import java.io.InputStream;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-23
 */
public class DataDynamicBindingExample {

    public static void main(String[] args){
        DataDynamicBindingExample example = new DataDynamicBindingExample();
        // read bean properties in a map
        example.dynamicDataBinding();
    }

    private void dynamicDataBinding(){
        try(InputStream is = this.getClass().getResourceAsStream("/albums4r.json")){
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            AlbumDynamic album = mapper.readValue(is, AlbumDynamic.class);
            System.out.println("AlbumDynamic title: " + album.getTitle());
            DatasetDynamic[] datasets = album.getDataset();
            for(DatasetDynamic dataset : datasets){
                System.out.println("DatasetDynamic all other properties: " + dataset.getOtherProperties());
                System.out.println("DatasetDynamic album_id: " + dataset.getAlbumId());
                System.out.println("DatasetDynamic album_title: " + dataset.getAlbumTitle());
                System.out.println("DatasetDynamic album_url: " + dataset.getProperty("album_url"));
                System.out.println("DatasetDynamic album_type: " + dataset.getProperty("album_type"));
            }
        }catch(Exception e){
            System.err.println("Dynamic Data Binding, Error: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}

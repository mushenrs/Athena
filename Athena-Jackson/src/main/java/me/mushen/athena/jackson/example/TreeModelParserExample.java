package me.mushen.athena.jackson.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-19
 */
public class TreeModelParserExample {

    public static void main(String[] args){
        TreeModelParserExample example = new TreeModelParserExample();
        // parser Json to JavaNode with get() method
        example.parserJsonAsTreeModelWithGet();
        // parser Json to JavaNode with path() method
        example.parserJsonAsTreeModelWithPath();
    }

    private void parserJsonAsTreeModelWithGet(){
        try(InputStream is = this.getClass().getResourceAsStream("/albums4r.json");){
            // Get the contents of json as a string using commons IO IOUTils class.
            String genreJson = IOUtils.toString(is, "UTF-8");
            // use the ObjectMapper to read the json string and create a tree
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(genreJson);
            // find out what fields it has: title, message, errors, total, total_pages, page, limit, dataset
            List<String> fieldNameList = new ArrayList<>();
            Iterator<String> fieldNames = node.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                fieldNameList.add(fieldName);
            }
            System.out.println("Fields: " + fieldNameList);
            // title is String, get it's value
            System.out.println("title's value: " + node.get("title").asText());
            // errors is array
            System.out.println("errors is Array: " + node.get("errors").isArray());
            // total_pages is int, get it's value
            System.out.println("total_pages is Integer, it's value: " + node.get("total_pages").asInt());
            // album_title is not a fieldName of this JavaNode
            System.out.println("album_title is a fieldName: " + (node.get("album_title") != null));
            // look at dataset, it's array too
            JsonNode dataset = node.get("dataset");
            // iterate through the array and see what each of the elements are
            // elements() as same calling iterator()
            Iterator<JsonNode> datasetElements = dataset.elements();
            // get all dataset field name
            boolean hasDatasetField = false;
            List<String> datasetElementFieldList = new ArrayList<>();
            // get dataset all album_title
            List<String> datasetAlbumTitles = new ArrayList<>();
            // get dataset all album_producer, may be null
            List<String> datasetAlbumProducers = new ArrayList<>();
            while(datasetElements.hasNext()){
                JsonNode datasetElement = datasetElements.next();
                // get dataset fields
                if(!hasDatasetField){
                    Iterator<String> datasetElementFields = datasetElement.fieldNames();
                    while (datasetElementFields.hasNext()) {
                        String datasetElementField = datasetElementFields.next();
                        datasetElementFieldList.add(datasetElementField);
                    }
                    hasDatasetField = true;
                }
                datasetAlbumTitles.add(datasetElement.get("album_title").asText());
                datasetAlbumProducers.add(datasetElement.get("album_producer").asText());
            }
            System.out.println("dataset Fields: " + datasetElementFieldList);
            System.out.println("All Album Title: " + datasetAlbumTitles);
            System.out.println("All Album Producer: " + datasetAlbumProducers);
        }catch(Exception e){
            System.err.println("Parser Json To JavaNode, Error:" + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    private void parserJsonAsTreeModelWithPath(){
        try(InputStream is = this.getClass().getResourceAsStream("/albums4r.json");){
            // Get the contents of json as a string using commons IO IOUTils class.
            String genreJson = IOUtils.toString(is, "UTF-8");
            // use the ObjectMapper to read the json string and create a tree
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(genreJson);
            // album_title field is not one field of current JavaNode
            JsonNode albumTitle = node.path("album_title");
            System.out.println("album_title's JavaNode is: " + albumTitle.getNodeType());
            System.out.println("album_title's JavaNode is MissingNode: " + albumTitle.isMissingNode());
            // not the use of path. this does not cause the code to break if the
            // code does not exist
            Iterator<JsonNode> albums = node.path("dataset").iterator();
            while (albums.hasNext()) {
                System.out.println(albums.next().path("album_title").asText());
            }
        }catch(Exception e){
            System.err.println("Parser Json To JavaNode, Error:" + e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}

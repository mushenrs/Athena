package me.mushen.athena.spring.jackson.example;

import com.fasterxml.jackson.core.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-19
 */
public class StreamParserGeneratorExample {

    public static void main(String[] args) throws Exception {
        StreamParserGeneratorExample example = new StreamParserGeneratorExample();
        // Json Parsing Example
        example.streamParser();
        // Json Generation Example
        example.streamGenerator();
    }

    private void streamParser() {
        // get JsonParser instance by JsonFactory
        JsonFactory factory = new JsonFactory();
        try(InputStream is = this.getClass().getResourceAsStream("/albums4r.json");
            JsonParser parser = factory.createParser(is)){
            // dataset
            for(JsonToken token = parser.nextToken(); token != null; token = parser.nextToken()){
                // token is field name && field name equals 'dataset'
                if(JsonToken.FIELD_NAME.equals(token) && "dataset".equals(parser.getCurrentName())) {
                    // we are entering the datasets now. The first token should be
                    // start of array '['
                    token = parser.nextToken();
                    if (!JsonToken.START_ARRAY.equals(token)) {
                        continue;
                    }
                    // token equal '[' will plus 1, and token equal ']' will minus 1
                    int arrayTokenCnt = 1;
                    // traversal The array and looking for a field that says "album_url"
                    while (arrayTokenCnt != 0) {
                        token = parser.nextToken();
                        if (JsonToken.START_ARRAY.equals(token)) {
                            arrayTokenCnt++;
                        } else if (JsonToken.END_ARRAY.equals(token)) {
                            arrayTokenCnt--;
                        } else if (JsonToken.FIELD_NAME.equals(token) && "album_url".equals(parser.getCurrentName())) {
                            // get album_url's value
                            parser.nextToken();
                            System.out.println("album_url = " + parser.getText());
                        }
                    }
                }
            }
        }catch(IOException e){
            System.err.println("Stream Parser Err..." + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    private void streamGenerator() throws IOException {
        // get JsonParser instance by JsonFactory
        JsonFactory factory = new JsonFactory();
        File file = new File("/tmp/albums4w.json");
        try(JsonGenerator generator = factory.createGenerator(file, JsonEncoding.UTF8)){
            // start writing with {
            generator.writeStartObject();
            generator.writeFieldName("title");
            generator.writeString("Free Music Archive - Albums");
            // start an array
            generator.writeFieldName("dataset");
            generator.writeStartArray();
            generator.writeStartObject();
            generator.writeStringField("album_title", "A.B.A.Y.A.M");
            generator.writeEndObject();
            generator.writeEndArray();
            generator.writeEndObject();

            System.out.println("Create Success /tmp/albums4w.json");
        }catch(IOException e){
            System.err.println("Stream Generator Err..." + e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}

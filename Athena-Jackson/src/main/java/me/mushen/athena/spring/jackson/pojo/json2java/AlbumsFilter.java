package me.mushen.athena.spring.jackson.pojo.json2java;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-22
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class AlbumsFilter {
    private String title;
    private DatasetFilter[] datasetFilter;
    public String total_pages;

    public String getTitle() {
        return title;
    }

    // this getter method is for the 'dataset' property
    @JsonProperty("dataset")
    public DatasetFilter[] getDatasetFilter() {
        return datasetFilter;
    }
}

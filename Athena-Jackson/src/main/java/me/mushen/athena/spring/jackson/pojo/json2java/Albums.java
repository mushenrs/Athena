package me.mushen.athena.spring.jackson.pojo.json2java;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-22
 */
public class Albums {
    private String title;
    private Dataset[] dataset;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDataset(Dataset[] dataset) {
        this.dataset = dataset;
    }

    public String getTitle() {
        return title;
    }

    public Dataset[] getDataset() {
        return dataset;
    }
}

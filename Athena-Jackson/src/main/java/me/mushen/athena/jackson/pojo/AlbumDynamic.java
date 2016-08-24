package me.mushen.athena.jackson.pojo;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-23
 */
public class AlbumDynamic {
    private String title;

    private DatasetDynamic[] dataset;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DatasetDynamic[] getDataset() {
        return dataset;
    }

    public void setDataset(DatasetDynamic[] dataset) {
        this.dataset = dataset;
    }
}

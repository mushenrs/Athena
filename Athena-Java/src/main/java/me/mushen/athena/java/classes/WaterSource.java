package me.mushen.athena.java.classes;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-21
 */
public class WaterSource {
    private String str;

    public WaterSource() {
        System.out.println("WaterSource()");
        str = "Constructed";
    }

    @Override
    public String toString() {
        return "WaterSource{" +
                "str='" + str + '\'' +
                '}';
    }
}

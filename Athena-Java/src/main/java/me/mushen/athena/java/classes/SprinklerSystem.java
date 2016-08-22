package me.mushen.athena.java.classes;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-21
 */
public class SprinklerSystem {
    private String val1, val2, val3, val4;

    private WaterSource waterSource = new WaterSource();

    private int i;

    private float f;

    public SprinklerSystem() {
        System.out.println("SprinklerSystem()");
    }

    @Override
    public String toString() {
        return "SprinklerSystem{" +
                "val1='" + val1 + '\'' +
                ", val2='" + val2 + '\'' +
                ", val3='" + val3 + '\'' +
                ", val4='" + val4 + '\'' +
                ", waterSource=" + waterSource +
                ", i=" + i +
                ", f=" + f +
                '}';
    }

    public static void main(String[] args){
        SprinklerSystem sprinklerSystem = new SprinklerSystem();
        System.out.println(sprinklerSystem);
    }
}

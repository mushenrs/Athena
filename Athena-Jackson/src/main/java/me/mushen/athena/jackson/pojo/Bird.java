package me.mushen.athena.jackson.pojo;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-24
 */
public class Bird {
    // Name
    private String name;
    // Sound
    private String sound;
    // Habitat
    private String habitat;

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", sound='" + sound + '\'' +
                ", habitat='" + habitat + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
}

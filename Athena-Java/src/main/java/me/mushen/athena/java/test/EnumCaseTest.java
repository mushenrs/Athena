package me.mushen.athena.java.test;

import static me.mushen.athena.java.test.Fruit.Apple;
import static me.mushen.athena.java.test.Fruit.Origin;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-09-05
 */
public class EnumCaseTest {
    public static void main(String[] args){
        String name = "banana";
        Fruit fruit = Fruit.get(name);
        switch (fruit){
            case Apple:
                System.out.println(Apple);
                break;
            case Origin:
                System.out.println(Origin);
                break;
            default:
                System.out.println(name);
        }
    }
}


enum Fruit {
    Null("null"),
    Apple("apple"),
    Origin("origin");

    private String name;

    Fruit(String name){
        this.name = name;
    }

    public static Fruit get(String name){
        for(Fruit fruit : Fruit.values()){
            if(fruit.name.equals(name)){
                return fruit;
            }
        }
        return Null;
    }
}

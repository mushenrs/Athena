package me.mushen.athena.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-14
 */
public class SimpleCollection {
    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<>();
        for(int i=0; i<10; i++){
            collection.add(i);
        }

        for(Integer i : collection){
            System.out.print(i + ",");
        }
    }
}

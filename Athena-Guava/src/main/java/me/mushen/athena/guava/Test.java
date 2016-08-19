package me.mushen.athena.guava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-16
 */
public class Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        System.out.println(list);
        Integer[] intArr = list.toArray(new Integer[list.size()]);

        System.out.println(Arrays.toString(intArr));
    }

}

package me.mushen.athena.java.java7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-24
 */
public class InvokeInstanceOfGenericClass {
    // 泛型推断
    public static void main(String[] args){
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "Remilia", "Flandre", "Cirno");
        System.out.println(stringList);
    }
}

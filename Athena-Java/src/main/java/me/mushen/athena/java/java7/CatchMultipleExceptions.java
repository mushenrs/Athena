package me.mushen.athena.java.java7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-26
 */
public class CatchMultipleExceptions {

    public static void main(String[] args){
        File file = new File("file");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(Integer.parseInt(s));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace(System.err);
        }
    }
}

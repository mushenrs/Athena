package me.mushen.athena.java.classes;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-21
 */
public class Detergent extends Cleanser {
    public void printStr(){
        super.printStr();
        System.out.println("Detergent");
    }

    public static void main(String[] args){
        Detergent detergent = new Detergent();
        detergent.printStr();
    }
}

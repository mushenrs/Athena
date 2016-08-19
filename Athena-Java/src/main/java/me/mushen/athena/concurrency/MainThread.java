package me.mushen.athena.concurrency;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-13
 */
public class MainThread {
    public static void main(String[] args){
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}

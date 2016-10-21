package me.mushen.athena.java.concurrency;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-19
 */
public class JavaThreadCreationAndRun {

    public static void main(String[] args){
        System.out.println("The main method was executed by thread: " + Thread.currentThread().getName());
        Helper helper = new Helper("Java Thread Creation And Run");

        Thread thread = new Thread(helper);
        thread.setName("A-Worker-Thread");
        thread.start();
    }

    static class Helper implements Runnable {
        private final String message;

        public Helper(String message) {
            this.message = message;
        }

        private void doSomething(String message){
            System.out.println("The doSomething method was executed by thread: " + Thread.currentThread().getName());
            System.out.println("Do something with " + message);
        }

        @Override
        public void run() {
            doSomething(message);
        }
    }
}

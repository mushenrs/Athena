package me.mushen.athena.spring.concurrency;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-13
 */
public class CallableDemo {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for(int i=0; i<10; i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }
        exec.shutdown();
        for(Future<String> result : results){
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

package me.mushen.athena.java.concurrency;

import java.util.concurrent.Callable;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-13
 */
public class TaskWithResult implements Callable<String>{
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        if(id % 3 == 0){
            Thread.sleep(10000L);
        }
        return "result of TaskWithResult: " + id;
    }
}

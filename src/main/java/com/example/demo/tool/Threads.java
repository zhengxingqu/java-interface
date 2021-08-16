package com.example.demo.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threads {
    public void threadRun(Integer length) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i = 0; i < length; i++){
            es.submit(new Tasks());
        }
    }

}

class Tasks implements Runnable{

    @Override
    public void run() {

    }
}

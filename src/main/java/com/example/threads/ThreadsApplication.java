package com.example.threads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ThreadsApplication {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int[] solutions = new int[1000000];

        for(int a = 1; a < 1000000; a++) {
            for(int b = 1; a * b < 1000000; b++) {
                int aw = a;
                int bw = b;
                executorService.execute(() ->{
                    if((aw + bw) % 4 == 0 && (3 * bw - aw) % 4 == 0 && 3 * bw  > aw) {
                        solutions[aw*bw]++;
                    }
                });
            }
        }

        int count = 0;
        for(int i = 0; i < solutions.length; i++) {
            if(solutions[i] == 10) {
                count++;
            }
        }
        SpringApplication.run(ThreadsApplication.class, args);
        System.out.println(count);
    }

}

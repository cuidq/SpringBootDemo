package com.example.demo.action;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: admin
 * @Date: 2018/8/21 09:19
 * @Description:
 */
@RestController
@Slf4j
public class suanFaController {
    @RequestMapping("")
    public String reverse() {
        String str = "";
        return str;
    }


    public static int count = 0;
    public static int clientTotal = 5000;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    add();
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
    }

    private static void add() {
        count++;
    }

}

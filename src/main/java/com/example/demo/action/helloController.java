package com.example.demo.action;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class helloController {
    @RequestMapping("/hello")
    public String say() {
        return "hello world";
    }
}

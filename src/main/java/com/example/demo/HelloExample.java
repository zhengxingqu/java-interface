package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello Example
 *
 * @author 恒宇少年
 */
@RestController
public class HelloExample {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }
}

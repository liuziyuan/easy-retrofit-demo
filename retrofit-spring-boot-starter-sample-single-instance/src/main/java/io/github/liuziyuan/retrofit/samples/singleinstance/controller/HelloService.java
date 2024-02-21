package io.github.liuziyuan.retrofit.samples.singleinstance.controller;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hello(String message) {
        return "Hello " + message;
    }
}

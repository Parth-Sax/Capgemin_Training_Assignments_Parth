package com.capgi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Controller {
    @GetMapping("/hi")
    public String hello() {
        return "Hello folks";
    }
    @GetMapping("/bye")
    public String give(){
        return "Bye Lads";
    }
}

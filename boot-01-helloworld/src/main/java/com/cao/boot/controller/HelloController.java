package com.cao.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

//@ResponseBody
//@Controller

@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String handel01(){
        return "Hello springBoot2";
    }
}

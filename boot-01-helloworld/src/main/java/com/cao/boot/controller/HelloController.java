package com.cao.boot.controller;

import com.cao.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

//@ResponseBody
//@Controller

@RestController
public class HelloController {

    @Autowired
    private Car car;
    @RequestMapping("/car")
    public Object getCar(){
        return car;
    }
    @RequestMapping("/hello")
    public String handel01(){
        return "Hello springBoot2";
    }
}

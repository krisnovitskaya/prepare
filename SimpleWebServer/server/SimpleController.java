package ru.krisnovitskaya.SimpleWebServer.server;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {

    @GetMapping("/simple")
    public String isAlive(){
        return "I am alive!";
    }

    @PostMapping("/simple")
    public String  customIsAlive(String name, String position){
        return  "Welcome, " + position +" "+ name + "!";
    }


    @GetMapping(path = "/object", produces = "application/json")
    public SimpleObject getSimpleObject(){
        return new SimpleObject("Test name", 10);
    }

    @PostMapping(path = "/object", consumes = "application/json",produces = "application/json")
    public SimpleObject updateSimpleObject(@RequestBody SimpleObject postObject ){
        return new SimpleObject(postObject.getTitle(), postObject.getCount());
    }
}

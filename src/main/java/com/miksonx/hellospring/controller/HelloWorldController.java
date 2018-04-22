package com.miksonx.hellospring.controller;

/**
 * Created by mspasovski on 2018-04-21.
 */
import com.miksonx.hellospring.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@EnableAutoConfiguration
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(path = "/helloworld")
    @ResponseBody
    public String printHelloWorldToConsole() {
        helloWorldService.printHelloWorld();

        return "Hello MiksonX";
    }
    @RequestMapping(path = "/")
    @ResponseBody
    public String printWelcomePage() {
        return "Hello MiksonX";
    }
}

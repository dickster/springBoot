package com.brovada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    // need to tell spring to reroute all angular genrated urls back to SPA index.html
//    @RequestMapping({  "/foo/{id:\\w+}" })
    @RequestMapping({ "/", "/app","/insured", "/chat", "/create", "/login",  "/location" })
    public String index() {
        return "forward:/index.html";
    }

}

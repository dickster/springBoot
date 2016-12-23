package com.brovada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping({ "/insured", "/chat", "/create", "/login", "/foo/{id:\\w+}", "/location" })
    public String index() {
        return "forward:/index.html";
    }

}

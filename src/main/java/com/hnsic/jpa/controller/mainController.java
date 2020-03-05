package com.hnsic.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName mainController
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/23 0023  15:42
 * Version   1.0
 **/
@Controller
public class mainController {
    @GetMapping(value = "main")
    public String toMain(){
        return "index";
    }
    @GetMapping(value = "test")
    public String totest(){
        return "test";
    }
}

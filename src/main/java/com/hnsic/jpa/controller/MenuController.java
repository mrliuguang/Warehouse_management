package com.hnsic.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName MenuController
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/28 0028  12:26
 * Version   1.0
 **/
@Controller
public class MenuController {
    @GetMapping(value = "/menu/{menu}")
    public String Menu(@PathVariable String menu){
        if(menu.equals("入库"))
        return "add_edit/order";
        return "index";
    }
}

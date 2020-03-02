package com.hnsic.jpa.controller;

import com.hnsic.jpa.entity.po.Product;
import com.hnsic.jpa.respository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * ClassName SearchController
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/5 0005  14:23
 * Version   1.0
 **/
@Controller
public class SearchController {

    @Autowired
    ProductRespository productRespository;
    @GetMapping(value = "Search/{name}/{page}")
    public String search(@PathVariable String name,@PathVariable Integer page, Model model){
        List<Product> products = productRespository.findLikeName("%"+name+"%");
        Product product=new Product();
        product.setProduct_name(name);
        ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Product> of = Example.of(product, matcher);
        Page<Product> all = (Page<Product>) productRespository.findAll(of,PageRequest.of(1, 10));
        model.addAttribute("products",all.getContent());
        model.addAttribute("page", page);
        return "show";
    }
}

package com.hnsic.jpa.controller;
/**
 * ClassName studentController
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/4 0004  17:27
 * Version   1.0
 **/

import com.hnsic.jpa.entity.po.Product;
import com.hnsic.jpa.entity.vo.ProductVo;
import com.hnsic.jpa.respository.ProductRespository;
import com.hnsic.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class productController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRespository productRespository;
    @GetMapping(value = "/toProductAdd")
    public String toAdd(){
        System.out.println("toproductadd");
        return "add_edit/product";
    }
    @GetMapping("/Products/{page}")//获得所有货物信息
    public String showAllProduct(@PathVariable Integer page,Model model){
        Page<ProductVo> productvos = productService.findall(page);
        model.addAttribute("products",productvos.getContent());
        model.addAttribute("page", page);
        return "showProduct";
    }
    @GetMapping("/Product/{id}")//获得指定学号的货物信息
    public String findProductById(@PathVariable Integer id,Model model){
        System.out.println("edit: "+id);
        Product product = productRespository.findByStudentId(id);
        System.out.println(product);
        model.addAttribute("product", product);
        return "add_edit/recording";
    }
    @PostMapping(value = "/Product")//增加一个货物信息
    public String addProduct(Product product){
        System.out.println("add");
        System.out.println("addproduct: "+product);
        productRespository.save(product);
        return "redirect:/Products/1";
    }
    @PutMapping(value = "/Product")//修改货物信息
    public String editProductById(Product product, Model model){
        System.out.println("editproduct: "+product);
        productRespository.saveAndFlush(product);
        return "redirect:/Products/1";
    }
    @DeleteMapping(value = "/Product/{id}")
    public String deleteProduct(@PathVariable int id){
        System.out.println("delete :"+id);
        productRespository.deleteById(id);
        return "redirect:/Products/1";
    }

}

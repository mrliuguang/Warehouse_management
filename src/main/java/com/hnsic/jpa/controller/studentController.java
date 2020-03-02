//package com.hnsic.jpa.controller;
//
///**
// * ClassName studentController
// * Description too
// * Aouthor   Administrator
// * Date      2020/2/4 0004  17:27
// * Version   1.0
// **/
//
//import com.hnsic.jpa.entity.Student;
//import com.hnsic.jpa.respository.StudentRespository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class studentController {
//    @Autowired
//    StudentRespository studentRespository;
//    @GetMapping("/Students/{page}")//获得所有学生信息
//    public String showAllStudent(@PathVariable Integer page,Model model){
////        List<Student> students = studentRespository.findAll();
//        Page<Student> all = studentRespository.findAll(PageRequest.of(page-1, 10));
//        model.addAttribute("students",all.getContent()/*students*/);
//        model.addAttribute("page", page);
//        return "show";
//    }
//    @GetMapping("/Student/{id}")//获得指定学号的学生信息
//    public String findStudentById(@PathVariable Integer id,Model model){
//        System.out.println("edit: "+id);
//        Student student = studentRespository.findByStudentId(id);
//        System.out.println(student);
//        model.addAttribute("student", student);
//        return "student/add";
//    }
////    @PostMapping("/user/{id}")
////    public String findStudentByName(@PathVariable String name){
////        studentRespository.findByName(name);
////        return "show";
////    }
//    @PostMapping(value = "/Student")//增加一个学生信息
//    public String addStudent(Student student){
//        System.out.println("addstudent: "+student);
//        studentRespository.save(student);
//        return "redirect:/Students/1";
//    }
//    @PutMapping(value = "/Student")//修改学生信息
//    public String editStudentById(Student student, Model model){
//        System.out.println("editstudent: "+student);
//        studentRespository.saveAndFlush(student);
//        return "redirect:/Students";
//    }
//    @DeleteMapping(value = "/Student/{id}")
//    public String deleteStudent(@PathVariable int id){
//        System.out.println("delete :"+id);
//        studentRespository.deleteById(id);
//        return "redirect:/Students";
//    }
//    @GetMapping(value = "toAdd")
//    public String toAdd(){
//        System.out.println("toadd");
//        return "student/add";
//    }
//
//    public studentController() {
//    }
//}

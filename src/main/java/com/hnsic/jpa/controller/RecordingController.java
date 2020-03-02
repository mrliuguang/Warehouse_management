package com.hnsic.jpa.controller;

import com.hnsic.jpa.entity.po.Recording;
import com.hnsic.jpa.respository.RecordingRespository;
import com.hnsic.jpa.service.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * ClassName RecodingController
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/22 0022  14:41
 * Version   1.0
 **/
@Controller
public class RecordingController {
    @Autowired
    RecordingService recordingService;
    @Autowired
    RecordingRespository recordingRespository;
    @GetMapping(value = "/toRecordingAdd")
    public String toAdd(){
        System.out.println("toRecordingadd");
        return "add_edit/recording";
    }
    @PostMapping(value = "/Recording")//增加一个货物信息
    public String addRecording(Recording recording){
        System.out.println("addRecording: "+recording);
        recordingService.saveRecording(recording);
        return "redirect:/Recordings/1";
    }
    @GetMapping(value="/Recordings/{page}")//获得所有货物记录信息
    public String showAllRecording(@PathVariable Integer page, Model model){
        Page<Recording> recordings = recordingService.findall(page);
        model.addAttribute("recordings",recordings.getContent());
        model.addAttribute("page", page);
        return "show";
    }
    @GetMapping(value="/Recording/{id}")//获得指定学号的货物信息
    public String findRecordingById(@PathVariable Integer id,Model model){
        System.out.println("edit: "+id);
        Optional<Recording> byId = recordingRespository.findById(id);
        Recording recording = byId.get();
        model.addAttribute("recording", byId.get());
        return "add_edit/recording";
    }
    @PutMapping(value = "/Recording")//修改货物信息
    public String editRecordingById(Recording recording, Model model){
        System.out.println("editrecording: "+recording);
        recordingRespository.saveAndFlush(recording);
        return "redirect:/Recordings/1";
    }
    @DeleteMapping(value = "/Recording/{id}")
    public String deleteRecording(@PathVariable int id){
        System.out.println("delete :"+id);
        recordingService.deleteRecording(id);
        return "redirect:/Recordings/1";
    }
}

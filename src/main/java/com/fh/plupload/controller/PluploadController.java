package com.fh.plupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PluploadController {

    @RequestMapping("/plupload/upload")
    @ResponseBody
    public String upload(MultipartFile file){
        System.out.println(file);
        return "成功";
    }
}

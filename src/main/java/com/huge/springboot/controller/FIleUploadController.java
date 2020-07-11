package com.huge.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Desc:
 * @author:huge
 * @create:2020-07-08 17:40
 */
@Controller
public class FIleUploadController {
    //上传
    @PostMapping("upload")
    public String upload(Model model,
                         @RequestParam("filename")MultipartFile file,
                         HttpServletRequest request) throws IOException {
        //判断上传文件不能为空
        if(!file.isEmpty()){
            //获取上传文件路径
            String path = ResourceUtils.getURL("classpath:static").getPath()+"/images/";
            File file1=new File(path);
            if(!file1.exists()){
                file1.mkdirs();
            }
            //用于查看路径是否正确
            System.out.println(path);
            //获取上传文件名称
            String filename = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
            //保存文件
            file.transferTo(new File(path,filename));
            model.addAttribute("filename",filename);
            //跳转成功页面
            return "success";
        }
        return "error";
    }
    //跳转上传页面
    @RequestMapping("/toUpload")
    public String toUpload(){
        return "upload";
    }
}

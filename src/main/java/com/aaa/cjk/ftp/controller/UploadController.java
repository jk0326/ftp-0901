package com.aaa.cjk.ftp.controller;

import com.aaa.cjk.ftp.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author 陈佳康
 * @date 2019-09-01 21:16
 */
@Controller
public class UploadController {
    @Autowired
    private UploadService uploadService;


    @RequestMapping("/uploadFiles")
    @ResponseBody
    public Map<String,Object> upload(HttpSession session,MultipartFile[] file) {

        //此处不做判断，返回的数据交给前台判断
        return uploadService.fileUpload(session,file);
    }



}

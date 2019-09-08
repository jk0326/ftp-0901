package com.aaa.cjk.ftp.service;

import com.aaa.cjk.ftp.config.FtpProperties;
import com.aaa.cjk.ftp.mapper.UserHeadPicMapper;
import com.aaa.cjk.ftp.model.User;
import com.aaa.cjk.ftp.utils.FileNameUtil;
import com.aaa.cjk.ftp.utils.FtpUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈佳康
 * @date 2019-09-01 20:53
 */
@Service
public class UploadService {

    @Autowired
    private FtpProperties ftpProperties;

    @Autowired
    private UserHeadPicMapper userHeadPicMapper;

    /**
    * @author  陈佳康
    * @description 多文件上传
    */
    public Map<String,Object> fileUpload(HttpSession session,MultipartFile[] files) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<String> pathes = new ArrayList<String>();
        User user = (User) session.getAttribute("user");

        try {
            for (MultipartFile file : files) {
                if (!file.isEmpty()){
                // 1 获取原始文件名
                String oldName = file.getOriginalFilename();

                // 2 调用工具类生成新的文件名称前半部
                String fileName = FileNameUtil.getFileName(user.getId());

                // 3 获取文件名后缀
                String substring = oldName.substring(oldName.lastIndexOf("."));
                // 4 最终的文件名
                fileName+=substring;
                // 5 生成文件夹信息
                String filePath = new DateTime().toString("yyyy/MM/dd");
                Boolean aBoolean = FtpUtil.uploadFile(ftpProperties.getHost(), Integer.parseInt(ftpProperties.getPort()), ftpProperties.getUsername(), ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, fileName, file.getInputStream());

                if (aBoolean){
                    //上传成功，更新数据库
                    String showPath = ftpProperties.getHttpPath() + File.separator + filePath + File.separator + fileName;

                    // 无论数据库是否更新成功，只要上传到了FTP上，都应该回显数据
                    pathes.add(showPath);
                    int i = userHeadPicMapper.updateUserHeadPic(user.getId(), showPath);
                    if (i > 0){
                        // 数据库更新成
                        resultMap.put("code",200);
                        resultMap.put("result",pathes);
                    }else {
                        // 数据库更新失败
                        System.out.println("数据库出现问题");
                        resultMap.put("code",401);
                        resultMap.put("result",pathes);
                    }

                }else {
                    // 上传失败
                    System.out.println("FTP上传出现问题，请抓紧时间抢修");
                    resultMap.put("code",404);
                }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }


}

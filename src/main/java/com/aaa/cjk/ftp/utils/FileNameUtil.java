package com.aaa.cjk.ftp.utils;

import java.util.Random;

/**
 * @author 陈佳康
 * @date 2019-09-01 20:29
 */
public class FileNameUtil {
    
    /**
    * @author  陈佳康
    * @description 文件名的生成
    */
    public static String getFileName(Long userId){
        //获取当前时间的毫秒数
        long nowTime = System.currentTimeMillis();

        //2创建random对象
        Random random = new Random();
        // 3获取0-999之间的随机数
        Integer nextInt = random.nextInt(999);

        // %为占位符  03 表示三位，d代表数字，如果拼出来的随机数不够三位，则自动往前补0
        String format = String.format("%03d", nextInt);

        // 4 拼接出来的文件名
        String fileName = nowTime + userId + format;
        return fileName;

    }


}

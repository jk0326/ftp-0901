package com.aaa.cjk.ftp.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserHeadPicMapper {

    int updateUserHeadPic(@Param("uid") Long uid,@Param("filePath") String filePath);
}
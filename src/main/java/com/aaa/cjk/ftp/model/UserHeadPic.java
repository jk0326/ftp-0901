package com.aaa.cjk.ftp.model;

import java.io.Serializable;

/**
 * @author 陈佳康
 * @date 2019-09-02 20:40
 */
public class UserHeadPic implements Serializable {
    private Long uid;
    private String headPic;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserHeadPic that = (UserHeadPic) o;

        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        return headPic != null ? headPic.equals(that.headPic) : that.headPic == null;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (headPic != null ? headPic.hashCode() : 0);
        return result;
    }
}

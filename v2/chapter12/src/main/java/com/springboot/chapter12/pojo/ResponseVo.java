package com.springboot.chapter12.pojo;

import java.util.Date;

public class ResponseVo {
       private String type;
       private Date objTime;
       private String userName;
       private String ipAdress;
       private String content;

    public void setType(String type) {
        this.type = type;
    }

    public void setObjTime(Date objTime) {
        this.objTime = objTime;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public Date getObjTime() {
        return objTime;
    }

    public String getUserName() {
        return userName;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public String getContent() {
        return content;
    }
}

package com.iblogstreet.googlepush.bean;

/**
 @author junwang
 @aate 2020/11/23 5:38 PM
 @desc 
**/
public class NotifyBean {
    public String title;
    public String content;
    public String link;

    public NotifyBean(String title, String content, String link) {
        this.title = title;
        this.content = content;
        this.link = link;
    }
}

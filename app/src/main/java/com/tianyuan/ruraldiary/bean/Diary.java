package com.tianyuan.ruraldiary.bean;

import java.io.Serializable;

/**
 * 日记模型
 */
public class Diary implements Serializable {
    private int id;
    //日记标题
    private String title;
    //日记内容
    private String content;
    //日记创建时间
    private String createtime;
    //日记创建星期
    private String week;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public int getId() {
        return id;
    }
    public String getTitle(){
        return title;
    }


    public String getContent() {
        return content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public String getWeek() {
        return week;
    }
}

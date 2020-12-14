package com.foodnav.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Menu {

    @TableId(type = IdType.AUTO)
    private int mid;
    private String title;
    private String path;

    public Menu() {
    }

    public Menu(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "mid=" + mid +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}

package com.foodnav.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Food {

    @TableId(type = IdType.AUTO)
    private int fid;
    private String foodname;
    private float price;
    private String realname1;

    public Food() {
    }

    public Food(String foodname, float price, String realname1) {
        this.foodname = foodname;
        this.price = price;
        this.realname1 = realname1;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getRealname1() {
        return realname1;
    }

    public void setRealname1(String realname1) {
        this.realname1 = realname1;
    }

    @Override
    public String toString() {
        return "Food{" +
                "fid=" + fid +
                ", foodname='" + foodname + '\'' +
                ", price=" + price +
                ", realname1='" + realname1 + '\'' +
                '}';
    }
}

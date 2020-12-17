package com.foodnav.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Owner {

    @TableId(type= IdType.AUTO)
    private int oid;
    private String addr;
    private String tel;
    private String realname;

    public Owner() {
    }

    public Owner(String addr, String tel, String realname) {
        this.addr = addr;
        this.tel = tel;
        this.realname = realname;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "oid=" + oid +
                ", addr='" + addr + '\'' +
                ", tel='" + tel + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}

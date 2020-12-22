package com.foodnav.controller;

import com.alibaba.fastjson.JSON;
import com.foodnav.bean.Owner;
import com.foodnav.bean.QueryInfo;
import com.foodnav.dao.OwnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    private OwnerDao oDao;

    @RequestMapping("/allOwner")
    public String getOwnerList(QueryInfo queryInfo){
        //获取最大列表数和当前编号
        int numbers=oDao.getOwnerCounts("%"+queryInfo.getQuery()+"%");
        int pageStart=(queryInfo.getPageNum()-1)*queryInfo.getPageSize();

        List<Owner> owners=oDao.getAllOwner("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();

        res.put("numbers",numbers);
        res.put("data",owners);

        String res_json = JSON.toJSONString(res);

        return res_json;
    }

    @RequestMapping("/rankOwner")
    public String getRankOwner(){
        List<Owner> rankOwner=oDao.getRankOwner();
        HashMap<String, Object> rs = new HashMap<>();

        rs.put("data",rankOwner);

        String rs_json = JSON.toJSONString(rs);

        return rs_json;
    }

    @RequestMapping("/addOwner")
    public String addOwner(@RequestBody Owner owner){
        int i = oDao.addOwner(owner);
        return i>0?"success":"error";
    }

    @RequestMapping("/registerOwner")
    public String registerOwner(String realname){
        String flag="success";
        List<Owner> owners = oDao.registerOwner(realname);

        if (owners.isEmpty()){
            flag="error";
        }
        return  flag;
    }

    @RequestMapping("/ownerOr")
    public String ownerOr(String realname){
        String flag="error";
        List<Owner> ownerList = oDao.ownerOr(realname);

        if (ownerList.isEmpty()){
            flag="success";
        }
        return  flag;
    }

    @RequestMapping("/deleteOwner")
    public String deleteOwner(int oid){
        int i = oDao.deleteOwner(oid);
        return i>0?"success":"error";
    }

    @RequestMapping("/getUpdateOwner")
    public String getUpdateOwner(int oid){
        Owner owner = oDao.getUpdateOwner(oid);
        String resJ = JSON.toJSONString(owner);

        return resJ;
    }

    @RequestMapping("/editOwner")
    public String editOwner(@RequestBody Owner owner){
        int i = oDao.editOwner(owner);
        return i>0?"success":"error";
    }
}

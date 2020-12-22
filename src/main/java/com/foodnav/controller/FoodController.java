package com.foodnav.controller;

import com.alibaba.fastjson.JSON;
import com.foodnav.bean.Food;
import com.foodnav.bean.QueryInfo;
import com.foodnav.dao.FoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodDao fDao;

    @RequestMapping("/rankFood")
    public String getRankFood(String realname1){
        List<Food> rankFood=fDao.getRankFood(realname1);
        HashMap<String, Object> rs = new HashMap<>();

        rs.put("data",rankFood);

        String rs_json = JSON.toJSONString(rs);
        return rs_json;
    }

    @RequestMapping("/allFood")
    public String getFoodList(String realname1,int pageStart,int pageSize){
        int numbers=fDao.getFoodCounts(realname1);

        int pageStart1=(pageStart-1)*pageSize;
        List<Food> foodList = fDao.getFoodList(realname1,pageStart1,pageSize);

       HashMap<String, Object> res = new HashMap<>();
       res.put("numbers",numbers);
       res.put("data",foodList);

       String res_json = JSON.toJSONString(res);

       return res_json;
    }

    @RequestMapping("/addFood")
    public String addFood(@RequestBody Food food){
        int i = fDao.addFood(food);
        return i>0?"success":"error";
    }

    @RequestMapping("/deleteFood")
    public String deleteFood(int fid){
        int i = fDao.deleteFood(fid);
        return i>0?"success":"error";
    }

    @RequestMapping("/getUpdateFood")
    public String getUpdateFood(int fid){
        Food food = fDao.getUpdateFood(fid);
        String resJ = JSON.toJSONString(food);
        return resJ;
    }

    @RequestMapping("/editFood")
    public String editFood(@RequestBody Food food){
        int i = fDao.editFood(food);
        return i>0?"success":"error";
    }
}

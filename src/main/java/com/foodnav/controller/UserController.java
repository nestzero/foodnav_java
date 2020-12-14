package com.foodnav.controller;

import com.alibaba.fastjson.JSON;
import com.foodnav.bean.QueryInfo;
import com.foodnav.bean.User;
import com.foodnav.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserDao uDao;

    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        //获取最大列表数和当前编号
        int numbers = uDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart=(queryInfo.getPageNum()-1)*queryInfo.getPageSize();

        List<User> users = uDao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);

        String res_json = JSON.toJSONString(res);
        return res_json;
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        int i = uDao.addUser(user);
        return i>0?"success":"error";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int uid){
        int i = uDao.deleteUser(uid);
        return i>0?"success":"error";
    }

    @RequestMapping("/getUpdate")
    public String getUpdateUser(int uid){
        User user = uDao.getUpdateUser(uid);
        String resJ = JSON.toJSONString(user);
        return resJ;
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        int i = uDao.editUser(user);
        return i>0?"success":"error";
    }
}

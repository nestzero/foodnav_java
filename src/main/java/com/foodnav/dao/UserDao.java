package com.foodnav.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.foodnav.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseMapper<User> {

    @Select("select * from user where username=#{username} and password=#{password}")
    public User getUserByMessage(@Param("username") String username,@Param("password") String password);

    @Select("select * from user where username like #{username} limit #{pageStart},#{pageSize}")
    public List<User> getAllUser(@Param("username") String username,@Param("pageStart") int pageStart,
                                 @Param("pageSize") int pageSize);

    @Select("select count(*) from user where username like #{username}")
    public int getUserCounts(@Param("username") String username);

    @Insert("insert into user(username,password,realname,root)" +
            "values(#{username},#{password},#{realname},#{root})")
    public int addUser(User user);

    @Delete("delete from user where uid=#{uid}")
    public int deleteUser(int uid);

    @Select("select * from user where uid=#{uid}")
    public User getUpdateUser(int uid);

    @Update("update user set password=#{password},realname=#{realname} where uid=#{uid}")
    public int editUser(User user);
}

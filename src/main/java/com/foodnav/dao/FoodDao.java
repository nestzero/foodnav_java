package com.foodnav.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.foodnav.bean.Food;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDao extends BaseMapper<Food> {

    @Select("select * from food where realname1=#{realname1} limit 0,5")
    public List<Food> getRankFood(@Param("realname1") String realname1);

    @Select("select * from food where realname1=#{realname1} limit #{pageStart},#{pageSize}")
    public List<Food> getFoodList(@Param("realname1") String realname1,
                                  @Param("pageStart") int pageStart,
                                  @Param("pageSize") int pageSize);

    @Select("select count(*) from food where realname1=#{realname1}")
    public int getFoodCounts(@Param("realname1") String realname1);

    @Insert("insert into food(foodname,price,realname1)" +
            "values(#{foodname},#{price},#{realname1})")
    public int addFood(Food food);

    @Delete("delete from food where fid=#{fid}")
    public int deleteFood(int fid);

    @Select("select * from food where fid=#{fid}")
    public Food getUpdateFood(int fid);

    @Update("update food set foodname=#{foodname},price=#{price} where fid=#{fid}")
    public int editFood(Food food);
}

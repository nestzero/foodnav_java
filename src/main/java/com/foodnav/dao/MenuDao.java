package com.foodnav.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.foodnav.bean.Menu;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao extends BaseMapper<Menu> {

    @Select("select * from menu")
    public List<Menu> getMenus();
}

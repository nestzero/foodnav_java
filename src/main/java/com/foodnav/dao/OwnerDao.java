package com.foodnav.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.foodnav.bean.Owner;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerDao extends BaseMapper<Owner> {

    @Select("select * from owner where addr like #{addr} limit #{pageStart},#{pageSize}")
    public List<Owner> getAllOwner(@Param("addr") String addr,@Param("pageStart") int pageStart,
                                   @Param("pageSize") int pageSize);

    @Select("select count(*) from owner where addr like #{addr}")
    public int getOwnerCounts(@Param("addr") String addr);

    @Select("select * from owner limit 0,5")
    public List<Owner> getRankOwner();

    @Insert("insert into owner(addr,tel,realname)values(#{addr},#{tel},#{realname})")
    public int addOwner(Owner owner);

    @Select("select * from user where realname=#{realname}")
    public List<Owner> registerOwner(@Param("realname") String realname);

    @Select("select * from owner where realname=#{realname}")
    public List<Owner> ownerOr(@Param("realname") String realname);

    @Delete("delete from owner where oid=#{oid}")
    public int deleteOwner(int oid);

    @Select("select * from owner where oid=#{oid}")
    public Owner getUpdateOwner(int oid);

    @Update("update owner set addr=#{addr},tel=#{tel} where oid=#{oid}")
    public int editOwner(Owner owner);
}

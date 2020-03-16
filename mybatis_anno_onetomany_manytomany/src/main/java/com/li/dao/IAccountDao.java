package com.li.dao;

import com.li.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户，并获得每个账户所属的用户信息
     * @Result(property = "user",column = "uid",one = @One(select="com.li.dao.IUserDao.findById",fetchType= FetchType.EAGER))
     *  property:要封装的属性名称
     *  column:通过uid去查找
     *  select:用户根据id查询时，所需要的参数值(全限定类名+方法名)
     *  fetchType:EAGER立即加载
     */
    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            @Result(property = "user",column = "uid",one=@One(select="com.li.dao.IUserDao.findById",fetchType = FetchType.EAGER)),
    })
    public List<Account> findAll();

    /**
     * 通过uid查询
     */
    @Select("select * from account where uid=#{uid}")
    public Account findByUid(Integer uid);
}

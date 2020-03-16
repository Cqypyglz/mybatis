package com.li.dao;

import com.li.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IUserDao {
    /**
     * 查询用户所对应所有的账户
     * 如果实体类的属性名和数据库的列名不一致时使用
     * id:唯一标志，别的地方也可应用
     *  @Results(id="userMap",value={})
     * 延迟加载
     * FetchType.LAZY
     *
     */
    @Select("select * from user")
    @Results(id="accountMap",value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "address",column = "address"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "accounts",column = "id",many = @Many(select = "com.li.dao.IAccountDao.findByUid",fetchType = FetchType.LAZY)),
    })
    public List<User> findAll();

    /**
     * 根据id查询
     */
    @Select("select * from user where id=#{id}")
    public User findById(Integer id);

}

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
     * 查询用户所对应的账户
     *
     */
    public List<User> findAll();

    /**
     * 根据id查询
     */
    public User findById(Integer id);

}

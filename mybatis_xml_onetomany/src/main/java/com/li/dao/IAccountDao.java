package com.li.dao;

import com.li.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询账户所对应的用户
     */
    public List<Account> findAll();

    /**
     * 通过uid查询
     */
    public Account findByUid(Integer uid);
}

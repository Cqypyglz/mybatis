package com.li.dao;

import com.li.domain.Role;

import java.util.List;

public interface IRoleDao {
    /**
     * 查询所有角色以及所对应的用户
     */
    public List<Role> findAll();

    public Role findByRid(Integer rid);
}

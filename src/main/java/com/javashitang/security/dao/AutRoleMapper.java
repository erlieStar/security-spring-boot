package com.javashitang.security.dao;

import com.javashitang.security.domain.AutRole;

public interface AutRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AutRole record);

    int insertSelective(AutRole record);

    AutRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutRole record);

    int updateByPrimaryKey(AutRole record);
}
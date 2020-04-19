package com.javashitang.security.dao;

import com.javashitang.security.domain.AutRoleFunMap;

public interface AutRoleFunMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AutRoleFunMap record);

    int insertSelective(AutRoleFunMap record);

    AutRoleFunMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutRoleFunMap record);

    int updateByPrimaryKey(AutRoleFunMap record);
}
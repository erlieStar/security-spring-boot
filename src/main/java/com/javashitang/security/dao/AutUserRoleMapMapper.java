package com.javashitang.security.dao;

import com.javashitang.security.domain.AutUserRoleMap;
import org.apache.ibatis.annotations.Param;

public interface AutUserRoleMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AutUserRoleMap record);

    int insertSelective(AutUserRoleMap record);

    AutUserRoleMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutUserRoleMap record);

    int updateByPrimaryKey(AutUserRoleMap record);

    int checkUserAuth(@Param("userId") Integer userId, @Param("autId") Integer autId);
}
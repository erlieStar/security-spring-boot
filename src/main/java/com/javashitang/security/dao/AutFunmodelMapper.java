package com.javashitang.security.dao;

import com.javashitang.security.domain.AutFunmodel;

import java.util.Collection;

public interface AutFunmodelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AutFunmodel record);

    int insertSelective(AutFunmodel record);

    AutFunmodel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutFunmodel record);

    int updateByPrimaryKey(AutFunmodel record);

    int deleteById(Collection<AutFunmodel> list);

    int insertBatch(Collection<AutFunmodel> list);
}
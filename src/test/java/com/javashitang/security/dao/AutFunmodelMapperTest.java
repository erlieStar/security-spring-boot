package com.javashitang.security.dao;

import com.javashitang.security.SecurityApplicationTests;
import com.javashitang.security.domain.AutFunmodel;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

public class AutFunmodelMapperTest extends SecurityApplicationTests {

    @Autowired
    private AutFunmodelMapper autFunmodelMapper;

    @Test
    @Transactional
    public void deleteById() {
        List<AutFunmodel> autFunmodelList = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            AutFunmodel autFunmodel = new AutFunmodel();
            autFunmodel.setId(i);
            autFunmodel.setParentId(i);
            autFunmodel.setName(String.valueOf(i));
            autFunmodel.setMapping(String.valueOf(i));
            autFunmodelList.add(autFunmodel);
        }
        autFunmodelMapper.deleteById(autFunmodelList);
    }

    @Test
    @Transactional
    public void insertBatch() {
        List<AutFunmodel> autFunmodelList = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            AutFunmodel autFunmodel = new AutFunmodel();
            autFunmodel.setId(i);
            autFunmodel.setParentId(i);
            autFunmodel.setName(String.valueOf(i));
            autFunmodel.setMapping(String.valueOf(i));
            autFunmodelList.add(autFunmodel);
        }
        int count = autFunmodelMapper.insertBatch(autFunmodelList);
        assertTrue(count > 0);
    }
}
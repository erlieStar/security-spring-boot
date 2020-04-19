package com.javashitang.security.dao;

import com.javashitang.security.SecurityApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AutUserRoleMapMapperTest extends SecurityApplicationTests {

    @Autowired
    private AutUserRoleMapMapper autUserRoleMapMapper;

    @Test
    public void checkUserAuth() {
        int count = autUserRoleMapMapper.checkUserAuth(1, 1);
    }
}
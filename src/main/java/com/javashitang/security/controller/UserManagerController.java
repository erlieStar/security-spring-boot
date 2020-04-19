package com.javashitang.security.controller;

import com.javashitang.security.annotation.AuthenRole;
import com.javashitang.security.common.TestRoleHandleFill;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lilimin
 * @Date: 2019/4/14 20:28
 */
@RestController
@RequestMapping("resource")
public class UserManagerController {

    @AuthenRole(id = TestRoleHandleFill.DEMO_AUT_ONE, parentId = TestRoleHandleFill.ROOT_ID)
    @RequestMapping("resource")
    public String test1() {
        return "test";
    }
}

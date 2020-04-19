package com.javashitang.security.common;

import org.springframework.stereotype.Component;

@Component
public class TestRoleHandleFill extends RoleHandleFill {

    public static final int DEMO_AUT_ONE = 10;
    public static final int DEMO_AUT_TWO = 11;

    @Override
    public String getRoleName(int autId) {
        switch (autId) {
            case DEMO_AUT_ONE:
                return "Demo权限1";
            case DEMO_AUT_TWO:
                return "Demo权限2";
        }
        return super.getRoleName(autId);
    }
}

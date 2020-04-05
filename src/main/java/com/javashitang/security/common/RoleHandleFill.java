package com.javashitang.security.common;

public class RoleHandleFill {

    public static final int ROOT_ID = -1;
    public static final int ALL_ROLE_PASS = -1;
    public static final int SYSTEM_CONFIG = -1;

    public String getRoleName(int roleId) {
        switch (roleId) {
            case -1:
                return "根目录";
            default:
                return null;
        }
    }

}

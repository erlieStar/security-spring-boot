package com.javashitang.security.common;

public abstract class RoleHandleFill {

    public static final int ROOT_ID = -1;

    public String getRoleName(int autId) {
        switch (autId) {
            case -1:
                return "根目录";
            default:
                return null;
        }
    }

}

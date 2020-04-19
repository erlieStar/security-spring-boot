package com.javashitang.security.util;

import com.javashitang.security.domain.LoginUserBaseInfo;

import javax.servlet.http.HttpServletRequest;

public class ParseUserBaseInfo {

    public static LoginUserBaseInfo parseUserInfoFromRequest(HttpServletRequest request) {
        return new LoginUserBaseInfo();
    }
}

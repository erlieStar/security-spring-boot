package com.javashitang.security.common;

import com.javashitang.security.annotation.AuthenRole;
import com.javashitang.security.domain.LoginUserBaseInfo;
import com.javashitang.security.service.inf.UserRoleMenuService;
import com.javashitang.security.util.ParseUserBaseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminGroupCtrlInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserRoleMenuService userRoleMenuService;

    private static final Logger logger = LoggerFactory.getLogger(AdminGroupCtrlInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            // 目前只对@RequestMapping类型的请求进行拦截
            return true;
        } else {
            HandlerMethod hd = (HandlerMethod) handler;
            AuthenRole authenRole = hd.getMethodAnnotation(AuthenRole.class);
            if (authenRole == null) {
                logger.info("pass without auth");
                return true;
            } else {
                LoginUserBaseInfo userInfo = ParseUserBaseInfo.parseUserInfoFromRequest(request);
                if (userInfo == null) {
                    logger.error("user not login");
                    return false;
                } else {
                    boolean authed = userRoleMenuService.hasRightAuth(userInfo.getId(), authenRole.id());
                    if (authed) {
                        return true;
                    } else {
                        logger.error("auth failed");
                        return false;
                    }
                }
            }
        }
    }
}

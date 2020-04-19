package com.javashitang.security.service.inf;

import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public interface UserRoleMenuService {

    boolean hasRightAuth(Integer userId, Integer authId);

    void updateMenuInfo2Db(RequestMappingHandlerMapping mapping);
}

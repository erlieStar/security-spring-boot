package com.javashitang.security.service.impl;

import com.javashitang.security.annotation.AuthenRole;
import com.javashitang.security.common.RoleHandleFill;
import com.javashitang.security.dao.AutFunmodelMapper;
import com.javashitang.security.dao.AutRoleFunMapMapper;
import com.javashitang.security.dao.AutRoleMapper;
import com.javashitang.security.dao.AutUserRoleMapMapper;
import com.javashitang.security.domain.AutFunmodel;
import com.javashitang.security.service.inf.UserRoleMenuService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

@Service
public class UserRoleMenuServiceImpl implements UserRoleMenuService {

    private static final Logger logger = LoggerFactory.getLogger(UserRoleMenuServiceImpl.class);

    @Autowired
    private RoleHandleFill roleHandleFill;
    @Autowired
    private AutFunmodelMapper autFunmodelMapper;
    @Autowired
    private AutRoleFunMapMapper autRoleFunMapMapper;
    @Autowired
    private AutRoleMapper autRoleMapper;
    @Autowired
    private AutUserRoleMapMapper autUserRoleMapMapper;

    @Override
    public boolean hasRightAuth(Integer userId, Integer authId) {
        int count = autUserRoleMapMapper.checkUserAuth(userId, authId);
        return count > 0 ? true : false;
    }

    @Override
    public void updateMenuInfo2Db(RequestMappingHandlerMapping mapping) {
        Set<AutFunmodel> autFunmodelSet = this.genMenuTree(mapping);
        this.postProcessMenu(autFunmodelSet);
    }


    private void postProcessMenu(Collection<AutFunmodel> models) {
        if (models != null && !models.isEmpty()) {
            this.autFunmodelMapper.deleteById(models);
            this.autFunmodelMapper.insertBatch(models);
        }
    }


    private final Set<AutFunmodel> genMenuTree(RequestMappingHandlerMapping mapHandler) {
        Map<RequestMappingInfo, HandlerMethod> map = mapHandler.getHandlerMethods();
        Iterator<Map.Entry<RequestMappingInfo, HandlerMethod>> it = map.entrySet().iterator();
        HashSet models = new HashSet();

        while(true) {
            while(true) {
                while(true) {
                    while(it.hasNext()) {
                        Map.Entry<RequestMappingInfo, HandlerMethod> entry = it.next();
                        RequestMappingInfo request = entry.getKey();
                        HandlerMethod hdm = entry.getValue();
                        AuthenRole ar = hdm.getMethodAnnotation(AuthenRole.class);
                        if (ar != null) {
                            Set<String> urls = request.getPatternsCondition().getPatterns();
                            if (urls != null && !urls.isEmpty() && urls.size() == 1) {
                                AutFunmodel pfunmodel = new AutFunmodel();
                                pfunmodel.setId(ar.parentId());
                                pfunmodel.setParentId(-1);
                                pfunmodel.setName(this.roleHandleFill.getRoleName(ar.parentId()));
                                if (!models.contains(pfunmodel)) {
                                    models.add(pfunmodel);
                                }

                                Iterator<String> uit = urls.iterator();
                                String url = uit.next();
                                AutFunmodel funmodel = new AutFunmodel();
                                funmodel.setId(ar.id());
                                funmodel.setParentId(ar.parentId());
                                funmodel.setName(this.roleHandleFill.getRoleName(ar.id()));
                                funmodel.setMapping(url);
                                if (models.contains(funmodel) && StringUtils.isEmpty(funmodel.getMapping())) {
                                    logger.error("found same id in menu or module, will skip : {}", funmodel);
                                } else {
                                    if (!StringUtils.isEmpty(funmodel.getMapping())) {
                                        models.remove(funmodel);
                                    }

                                    models.add(funmodel);
                                    logger.info("create menu/module: {}", funmodel);
                                }
                            } else {
                                logger.error("can not found matched pattern url mapping: {} => {} => {}", new Object[]{urls, request.getName(), request.getPatternsCondition()});
                            }
                        } else {
                            logger.info("skip AuthenRole detected: {}", hdm.getMethod());
                        }
                    }
                    return models;
                }
            }
        }
    }
}

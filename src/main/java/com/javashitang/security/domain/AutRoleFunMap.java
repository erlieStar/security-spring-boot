package com.javashitang.security.domain;

import java.time.LocalDateTime;

public class AutRoleFunMap {
    private Integer id;

    private Integer roleId;

    private Integer funModelId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public AutRoleFunMap(Integer id, Integer roleId, Integer funModelId, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.roleId = roleId;
        this.funModelId = funModelId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public AutRoleFunMap() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getFunModelId() {
        return funModelId;
    }

    public void setFunModelId(Integer funModelId) {
        this.funModelId = funModelId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
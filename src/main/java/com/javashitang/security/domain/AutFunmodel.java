package com.javashitang.security.domain;

import java.time.LocalDateTime;

public class AutFunmodel {
    private Integer id;

    private Integer parentId;

    private String name;

    private String mapping;

    private Integer rank;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public AutFunmodel(Integer id, Integer parentId, String name, String mapping, Integer rank, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.mapping = mapping;
        this.rank = rank;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public AutFunmodel() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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
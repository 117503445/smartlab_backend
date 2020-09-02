package com.wizzstudio.smartlab.dto;

import com.wizzstudio.smartlab.entity.BehaviorLogEntity;

public class BehaviorLogGetDto {
    private Integer id;
    private String openid;
    private String page;//页面
    private String control;//控件
    private long createdTimeStamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public long getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(long createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public static BehaviorLogGetDto fromEntity(BehaviorLogEntity behaviorLogEntity) {
        BehaviorLogGetDto behaviorLogGetDto = new BehaviorLogGetDto();
        behaviorLogGetDto.setId(behaviorLogEntity.getId());
        behaviorLogGetDto.setControl(behaviorLogEntity.getControl());
        behaviorLogGetDto.setCreatedTimeStamp(behaviorLogEntity.getCreatedTimeStamp());
        behaviorLogGetDto.setOpenid(behaviorLogEntity.getOpenid());
        behaviorLogGetDto.setPage(behaviorLogEntity.getPage());
        return behaviorLogGetDto;
    }
}

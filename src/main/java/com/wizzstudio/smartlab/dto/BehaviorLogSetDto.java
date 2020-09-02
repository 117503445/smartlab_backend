package com.wizzstudio.smartlab.dto;

import com.wizzstudio.smartlab.entity.BehaviorLogEntity;

public class BehaviorLogSetDto {

    private String openid;
    private String page;//页面
    private String control;//控件

    public BehaviorLogEntity toEntity(){
        BehaviorLogEntity behaviorLogEntity = new BehaviorLogEntity();
        behaviorLogEntity.setOpenid(openid);
        behaviorLogEntity.setPage(page);
        behaviorLogEntity.setControl(control);
        return behaviorLogEntity;
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
}

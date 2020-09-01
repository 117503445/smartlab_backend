package com.wizzstudio.smartlab.dto;

public class WechatOpenidGetDto {
    public WechatOpenidGetDto(String openid) {
        this.openid = openid;
    }

    private String openid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}

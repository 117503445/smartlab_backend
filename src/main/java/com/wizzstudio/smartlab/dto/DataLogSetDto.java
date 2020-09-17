package com.wizzstudio.smartlab.dto;

import com.wizzstudio.smartlab.entity.DataLogEntity;

public class DataLogSetDto {

    private String openid;
    private String page;//页面
    private String content;

    public DataLogEntity toEntity(){
        DataLogEntity dataLogEntity = new DataLogEntity();
        dataLogEntity.setOpenid(openid);
        dataLogEntity.setPage(page);
        dataLogEntity.setContent(content);
        return dataLogEntity;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

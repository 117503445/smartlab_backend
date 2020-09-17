package com.wizzstudio.smartlab.dto;

import com.wizzstudio.smartlab.entity.DataLogEntity;

public class DataLogGetDto {
    private Integer id;
    private String openid;
    private String page;//页面
    private String content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(long createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public static DataLogGetDto fromEntity(DataLogEntity dataLogEntity) {
        DataLogGetDto behaviorLogGetDto = new DataLogGetDto();
        behaviorLogGetDto.setId(dataLogEntity.getId());
        behaviorLogGetDto.setContent(dataLogEntity.getContent());
        behaviorLogGetDto.setCreatedTimeStamp(dataLogEntity.getCreatedTimeStamp());
        behaviorLogGetDto.setOpenid(dataLogEntity.getOpenid());
        behaviorLogGetDto.setPage(dataLogEntity.getPage());
        return behaviorLogGetDto;
    }
}

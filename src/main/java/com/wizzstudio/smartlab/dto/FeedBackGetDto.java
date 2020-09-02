package com.wizzstudio.smartlab.dto;

import com.wizzstudio.smartlab.entity.FeedbackEntity;

public class FeedBackGetDto {
    private Integer id;
    private String type;//问题类型
    private String content;//问题内容
    private String contactInfo;//联系方式
    private String openid;
    private String page;

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
    public static FeedBackGetDto fromEntity(FeedbackEntity feedbackEntity) {
        FeedBackGetDto feedBackGetDto = new FeedBackGetDto();
        feedBackGetDto.setContactInfo(feedbackEntity.getContactInfo());
        feedBackGetDto.setContent(feedbackEntity.getContent());
        feedBackGetDto.setId(feedbackEntity.getId());
        feedBackGetDto.setType(feedbackEntity.getType());
        feedBackGetDto.setOpenid(feedbackEntity.getOpenid());
        feedBackGetDto.setPage(feedbackEntity.getPage());
        return feedBackGetDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}

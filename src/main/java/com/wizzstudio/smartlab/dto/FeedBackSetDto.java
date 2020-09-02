package com.wizzstudio.smartlab.dto;

import com.wizzstudio.smartlab.entity.FeedbackEntity;

public class FeedBackSetDto {
    private String type;//问题类型
    private String content;//问题内容
    private String contactInfo;//联系方式

    public FeedbackEntity toEntity() {
        FeedbackEntity feedbackEntity = new FeedbackEntity();
        feedbackEntity.setContactInfo(contactInfo);
        feedbackEntity.setContent(content);
        feedbackEntity.setType(type);
        return feedbackEntity;
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

package com.wizzstudio.smartlab.entity;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class FeedbackEntity {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public static String getCSVHeader() {
        return "Id,openid,page,ContactInfo,Type,Content\n";
    }

    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s,%s\n", this.getId(), this.getOpenid(), this.getPage(), this.getContactInfo(), this.getType(), this.getContent());
    }
}

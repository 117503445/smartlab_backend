package com.wizzstudio.smartlab.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "behavior_log")
public class BehaviorLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)

    private Integer id;

    private String openid;
    private String page;//页面
    private String control;//控件

    @CreatedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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

    public static String getCSVHeader() {
        return "Id,CreatedTimeStamp,Openid,Page,Control\n";
    }

    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s\n", this.getId(),this.getCreatedTimeStamp(),this.getOpenid(),this.getPage(),this.getControl());
    }
}

package com.sie.app.newsdk.other.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;

import java.util.Date;
import java.util.Map;

/**
 * @author lijun10
 * @date 2023/1/10 10:27
 */
@Model
public class TestLog extends BaseModel<TestLog> {


    private Date createDate;


    private String remark;


    @ManyToOne(targetModel = "TestUser")
    @JoinColumn(name = "user_id")
    private Map<String,Object> testUser;


    public Date getCreateDate() {
        return (Date) this.get("createDate");
    }

    public TestLog setCreateDate(Date createDate) {
        this.set("createDate", createDate);
        return this;
    }

    public String getRemark() {
        return (String) this.get("remark");
    }

    public TestLog setRemark(String remark) {
        this.set("remark", remark);
        return this;
    }

    public Map<String, Object> getTestUser() {
        return (Map<String, Object>) this.get("testUser");
    }

    public TestLog setTestUser(Map<String, Object> testUser) {
        this.set("testUser", testUser);
        return this;
    }
}

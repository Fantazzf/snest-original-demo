package com.sie.app.newsdk.test.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Service;

/**
 * @author lijun10
 * @date 2023/2/9 14:00
 */
@Model(name = "Son",parent = "Student")
@Service(remove = {"testM1"})
public class StudentSon extends BaseModel {

    private String aaa;

    @MethodService
    public String testMethodAaa(){
        return "testMethodAaa";
    }

}

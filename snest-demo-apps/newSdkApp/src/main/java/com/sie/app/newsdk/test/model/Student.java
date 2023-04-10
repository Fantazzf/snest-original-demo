package com.sie.app.newsdk.test.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.meta.Service;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.validate.Validate;

/**
 * @author lijun10
 * @date 2023/2/8 15:49
 */
@Model
@Service(name="testM1")
public class Student extends BaseModel {

    @Property(displayName = "名字",length = 100)
    @Validate.NotBlank
    private String name;

    private Integer age;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @MethodService
    public String testS1(){
        return "testMethodAaa";
    }

}

package com.sie.app.newsdk.other.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;

/**
 * @author lijun10
 * @date 2023/2/9 14:41
 */
@Model(parent = "test_teacher")
public class TeacherSon extends BaseModel {
    private String teacherP1;

    @MethodService(name = "sayHello")
    public String sayHello(String str){
        this.getMeta().get("test_teacher").callSuper(Teacher.class,"sayHello","xxx");
        return "hello " + str + " come to foshan!";
    }


    @MethodService(name = "sayHello2")
    public String sayHello2(String str){
        return "hello2";
    }
}

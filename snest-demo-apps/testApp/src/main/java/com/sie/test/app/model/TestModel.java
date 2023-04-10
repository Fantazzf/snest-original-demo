package com.sie.test.app.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.OneToMany;
import com.sie.snest.sdk.annotation.validate.Validate;

import java.util.List;

/**
 * @author lijun10
 * @date 2023/3/13 9:00
 */
@Model(displayName = "组织")
public class TestModel extends BaseModel<TestModel> {

    @Property(displayName = "组织名称",displayForModel = true)
    private String name;

    @Validate.Email(message = "邮箱格式不正确")
    @Property
    private String email;

    @Validate.Phone(message = "手机号码格式不正确")
    @Property
    private String phone;


    @OneToMany
    private List<ManyTestModel> userList;

}

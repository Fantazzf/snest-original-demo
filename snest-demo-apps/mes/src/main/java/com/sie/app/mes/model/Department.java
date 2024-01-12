package com.sie.app.mes.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.validate.Validate;

@Model(name = "department",displayName = "宿舍信息",isAutoLog = Bool.True)
public class Department extends BaseModel<Department> {
    @Property(displayName = "名称",displayForModel = true)
    @Validate.NotBlank
    private  String name;

    public Department setName(String name) {
        this.set("name", name);
        return this;
    }

    public String getName() {
        return getStr("name");
    }
}

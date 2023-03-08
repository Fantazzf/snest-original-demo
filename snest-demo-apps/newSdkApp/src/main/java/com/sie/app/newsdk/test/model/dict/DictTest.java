package com.sie.app.newsdk.test.model.dict;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.Dict;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;

@Model(name = "base_dict_test", displayName = "字典测试")
public class DictTest extends BaseModel<DictTest> {
    @Property(displayName = "用户性别")
    @Dict(typeCode = "userSex", defaultValue = "0", multiple = true)
    private String test;
}

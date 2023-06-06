package com.sie.app.newsdk.test.model.demo;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.DataType;
import com.sie.snest.sdk.annotation.Dict;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import java.util.List;

/**
 * @author Kris
 */
@Model(displayName = "字典示例")
public class DictDemo extends BaseModel<DictDemo> {

    @Property(displayName = "用户性别")
    @Dict(typeCode = "userSex")
    private List<String> sex;

    @Property(displayName = "用户性别(多选)")
    @Dict(typeCode = "userSex", defaultValue = "0", multiple = true)
    private List<String> sexMulti;
}

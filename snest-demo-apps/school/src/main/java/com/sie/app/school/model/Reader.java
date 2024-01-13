package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;

@Model(name = "reader", description = "读者", isAutoLog = Bool.True)
public class Reader extends BaseModel<Reader> {
    @Property(displayName = "读者名称")
    private String readerName;

    @Property(displayName = "读者类型")
    private String readerType;
}

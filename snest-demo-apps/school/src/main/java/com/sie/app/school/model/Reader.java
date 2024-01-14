package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;

import java.util.Date;
import java.util.List;

@Model(name = "reader", description = "读者", isAutoLog = Bool.True)
public class Reader extends BaseModel<Reader> {
    @Property(displayName = "读者名称")
    private String readerName;

    @Property(displayName = "读者类型")
    private String readerType;

    public Reader setReaderName(String readerName) {
        this.set("readerName", readerName);
        return this;
    }

    public String getReaderName() {
        return getStr("readerName");
    }

    public Reader setReaderType(String readerType) {
        this.set("readerType", readerType);
        return this;
    }

    public String getReaderType() {
        return getStr("readerType");
    }
}

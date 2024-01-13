package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;

import java.util.Date;

@Model(name = "return_record",description = "还书记录",isAutoLog = Bool.True)
public class ReturnRecord extends BaseModel<ReturnRecord> {
    @Property(displayName = "读者")
    private Reader reader;

    @Property(displayName = "还书日期")
    private Date date;

    @Property(displayName = "所借图书信息")
    private Book book;

    @Property(displayName = "关联借书记录")
    private BorrowRecord borrowRecord;
}

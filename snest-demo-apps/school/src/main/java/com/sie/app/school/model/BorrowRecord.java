package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;

import java.util.Date;

@Model(name = "borrow_record",displayName = "借书记录",isAutoLog = Bool.True)
public class BorrowRecord extends BaseModel<BorrowRecord> {
    @Property(displayName = "读者")
    private Reader reader;

    @Property(displayName = "借书日期")
    private Date borrowDate;

    @Property(displayName = "所借图书信息")
    private Book borrowBook;
}

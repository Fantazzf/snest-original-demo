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
    private Date returndate;

    @Property(displayName = "所借图书信息")
    private Book book;

    @Property(displayName = "关联借书记录")
    private BorrowRecord borrowRecord;

    public ReturnRecord setReader(Reader reader) {
        this.set("reader", reader);
        return this;
    }

    public Reader getReader() {
        return (Reader) this.get("reader");
    }

    public ReturnRecord setReturndate(Date returndate) {
        this.set("returndate", returndate);
        return this;
    }

    public Date getReturndate() {
        return getDate("returndate");
    }

    public ReturnRecord setBook(Book book) {
        this.set("book", book);
        return this;
    }

    public Book getBook() {
        return (Book) this.get("book");
    }

    public ReturnRecord setBorrowRecord(BorrowRecord borrowRecord) {
        this.set("borrowRecord", borrowRecord);
        return this;
    }

    public BorrowRecord getBorrowRecord() {
        return (BorrowRecord) this.get("borrowRecord");
    }
}

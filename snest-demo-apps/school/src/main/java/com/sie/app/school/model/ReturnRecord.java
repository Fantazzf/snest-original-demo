package com.sie.app.school.model;

import com.sie.snest.engine.api.jsonrpc.JsonRpcServiceResponse;
import com.sie.snest.engine.model.Bool;
import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToMany;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.orm.OneToOne;
import com.sie.snest.sdk.annotation.validate.Validate;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Model(name = "return_record",description = "还书记录",isAutoLog = Bool.True)
public class ReturnRecord extends BaseModel<ReturnRecord> {

    @ManyToOne(displayName = "读者")
    @JoinColumn
    private Reader reader;

    @Property(displayName = "所借图书名称")
    private String returnBook;

    @ManyToOne(displayName = "关联借书记录")
    @JoinColumn
    @Validate.NotBlank
    private BorrowRecord borrowRecord;

    @Property(displayName = "还书日期")
    private Date returnDate;


    public ReturnRecord setReader(Reader reader) {
        this.set("reader", reader);
        return this;
    }

    public Reader getReader() {
        return (Reader) this.get("reader");
    }

    public ReturnRecord setReturnBook(String returnBook) {
        this.set("returnBook", returnBook);
        return this;
    }

    public String getReturnBook() {
        return getStr("returnBook");
    }

    public ReturnRecord setBorrowRecord(BorrowRecord borrowRecord) {
        this.set("borrowRecord", borrowRecord);
        return this;
    }

    public BorrowRecord getBorrowRecord() {
        return (BorrowRecord) this.get("borrowRecord");
    }

    public ReturnRecord setReturnDate(Date returnDate) {
        this.set("returnDate", returnDate);
        return this;
    }

    public Date getReturnDate() {
        return getDate("returnDate");
    }

}

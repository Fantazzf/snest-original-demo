package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import org.apache.commons.collections.CollectionUtils;

import java.util.Date;
import java.util.List;

@Model(name = "borrow_record",displayName = "借书记录",isAutoLog = Bool.True)
public class BorrowRecord extends BaseModel<BorrowRecord> {
    @Property(displayName = "读者")
    private Reader reader;

    @Property(displayName = "借书日期")
    private Date borrowDate;

    @Property(displayName = "所借图书信息")
    private Book borrowBook;

    public BorrowRecord setReader(Reader reader) {
        this.set("reader", reader);
        return this;
    }

    public Reader getReader() {
        return (Reader) this.get("reader");
    }

    public BorrowRecord setBorrowDate(Date borrowDate) {
        this.set("borrowDate", borrowDate);
        return this;
    }

    public Date getBorrowDate() {
        return getDate("borrowDate");
    }

    public BorrowRecord setBorrowBook(Book borrowBook) {
        this.set("borrowBook", borrowBook);
        return this;
    }

    public Book getBorrowBook() {
        return (Book) this.get("borrowBook");
    }

    @MethodService(name = "queryBorrowRecord",auth = "cyh",description = "查询借书记录")
    public BorrowRecord queryBorrowRecord(String bookName,Reader reader){
        List<BorrowRecord> borrowRecords=search(Filter.AND(Filter.equal("bookName",bookName),Filter.equal("reader",reader)),getAllProperties(),1,0,null);
        if(CollectionUtils.isEmpty(borrowRecords)){
            return null;
        }else{
            BorrowRecord borrowRecord=borrowRecords.get(0);
            return borrowRecord;
        }
    }
}

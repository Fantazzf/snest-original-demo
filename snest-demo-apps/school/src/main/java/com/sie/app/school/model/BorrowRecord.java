package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.JoinColumn;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import org.apache.commons.collections.CollectionUtils;

import java.util.Date;
import java.util.List;

@Model(name = "borrow_record",displayName = "借书记录",isAutoLog = Bool.True)
public class BorrowRecord extends BaseModel<BorrowRecord> {
    public BorrowRecord(Reader reader, Book borrowBook, Date borrowDate) {
        if(borrowBook.queryInLibrary()!=null&&borrowBook.getBookStatus()=="在馆"){
            this.reader = reader;
            this.borrowDate = borrowDate;
            this.borrowBook = borrowBook;
            borrowBook.setBookStatus("出借中");
            System.out.println(borrowBook.getBookStatus());
        }else{
            throw new RuntimeException("书籍状态异常！");
        }
    }
    @ManyToOne(displayName = "读者")
    @JoinColumn
    private Reader reader;

    @Property(displayName = "借书日期",displayForModel = true)
    private Date borrowDate;

    @ManyToOne(displayName = "所借图书信息")
    @JoinColumn
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

}

package com.sie.app.school.model;

import com.sie.snest.engine.api.jsonrpc.JsonRpcServiceResponse;
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
import java.util.Objects;

@Model(name = "borrow_record",displayName = "借书记录",isAutoLog = Bool.True)
public class BorrowRecord extends BaseModel<BorrowRecord> {

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

    @MethodService(name = "borrowBook",auth = "borrowBook",description = "借书")
    public void borrowBook(String bookName){
        Book curBook=(new Book()).queryInLibrary(bookName);
        if(curBook!=null){
            if(Objects.equals(curBook.getBookStatus(),"在馆")){
                curBook.setBookStatus("出借中");
                System.out.println(curBook.getBookStatus());
            }else{
                System.out.println("书籍已被借走！");
            }
        }else{
            System.out.println("图书馆尚未典藏该书籍！");
        }
    }

}

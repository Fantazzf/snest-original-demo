package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.Dict;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.Option;
import com.sie.snest.sdk.annotation.orm.Selection;
import org.checkerframework.checker.units.qual.A;

import java.util.Date;

@Model(name = "book", description = "图书", isAutoLog = Bool.True)
public class Book extends BaseModel<Book> {

    @Property(displayName = "图书编码")
    private Integer bookID;
    @Property(displayName = "图书名称")
    private String bookName;

    @Property(displayName = "图书类型")
    @Dict(typeCode = "book_type")
    private String bookType;

    @Property(displayName = "作者")
    private String author;

    @Property(displayName = "出版日期")
    private Date publishDate;

    @Selection(values = {
            @Option(label = "出借中", value = "2"),
            @Option(label = "在馆", value = "1")
    })
    @Property(displayName = "图书状态")
    private String bookStatus;

    public Book setBookID(Integer bookID) {
        this.set("bookID", bookID);
        return this;
    }

    public Integer getBookID() {
        return getInt("bookID");
    }

    public Book setBookName(String bookName) {
        this.set("bookName", bookName);
        return this;
    }

    public String getBookName() {
        return getStr("bookName");
    }

    public Book setBookType(String bookType) {
        this.set("bookType", bookType);
        return this;
    }

    public String getBookType() {
        return getStr("bookType");
    }

    public Book setAuthor(String author) {
        this.set("author", author);
        return this;
    }

    public String getAuthor() {
        return getStr("author");
    }

    public Book setPublishDate(Date publishDate) {
        this.set("publishDate", publishDate);
        return this;
    }

    public Date getPublishDate() {
        return getDate("publishDate");
    }

    public Book setBookStatus(String bookStatus) {
        this.set("bookStatus", bookStatus);
        return this;
    }

    public String getBookStatus() {
        return getStr("bookStatus");
    }

    @MethodService(name = "BookService", auth = "admin", description = "图书信息管理服务")
    public String BookService(String service){
        return "hello";
    }
}


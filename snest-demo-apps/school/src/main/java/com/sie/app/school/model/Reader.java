package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.Option;
import com.sie.snest.sdk.annotation.orm.Selection;

import java.util.Date;
import java.util.List;

@Model(name = "reader", description = "读者", isAutoLog = Bool.True)
public class Reader extends BaseModel<Reader> {
    @Property(displayName = "读者名称")
    private String readerName;

    @Property(displayName = "读者类型")
    @Selection(values = {
            @Option(label = "教师", value = "1"),
            @Option(label = "学生", value = "2")
    })
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

    @MethodService(name = "borrowBook",auth = "cyh",description = "借书")
    public String borrowBook(String borrowBookName){
        Book curBook=(new Book()).queryInLibrary(borrowBookName);
        if(curBook==null){
            System.out.println("本馆暂未典藏该书籍");
            return "本馆暂未典藏该书籍";
        }
        else{
            BorrowRecord borrowRecord=new BorrowRecord();
            borrowRecord.setReader(this);
            borrowRecord.setBorrowDate(new Date());
            borrowRecord.setBorrowBook(curBook);
            curBook.setBookStatus("出借中");
            System.out.println("借书成功");
            return "借书成功";
        }
    }

    @MethodService(name = "returnBook",auth = "cyh",description = "还书")
    public String returnBook(String returnBookName){
        BorrowRecord borrowRecord=(new BorrowRecord()).queryBorrowRecord(returnBookName,this);
        if(borrowRecord==null){
            System.out.println("您并未借出该书");
            return "您并未借出该书";
        }
        else{
            ReturnRecord returnRecord=new ReturnRecord();
            Date date=new Date();
            if(date.compareTo(borrowRecord.getBorrowDate())!=1){
                System.out.println("归还记录不能早于借出的日期");
                return "归还记录不能早于借出的日期";
            }else{
                Book curbook=borrowRecord.getBorrowBook();
                returnRecord.setReader(this);
                returnRecord.setReturndate(date);
                returnRecord.setBook(curbook);
                returnRecord.setBorrowRecord(borrowRecord);
                curbook.setBookStatus("在馆");
                System.out.println("还书成功");
                return "还书成功";
            }
        }
    }
}

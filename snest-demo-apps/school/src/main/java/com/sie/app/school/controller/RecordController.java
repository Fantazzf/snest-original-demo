package com.sie.app.school.controller;

import com.sie.app.school.model.Book;
import com.sie.app.school.model.BorrowRecord;
import com.sie.app.school.model.Reader;
import com.sie.app.school.model.ReturnRecord;
import com.sie.snest.sdk.annotation.meta.MethodService;

import java.util.Date;
public class RecordController {
    @MethodService(name = "borrowBook",auth = "cyh",description = "借书")
    public String borrowBook( Reader reader,String borrowBookName){
        Book curBook=(new Book()).queryInLibrary(borrowBookName);
        if(curBook==null){
            System.out.println("本馆暂未典藏该书籍");
            return "本馆暂未典藏该书籍";
        }
        else{
            BorrowRecord borrowRecord=new BorrowRecord();
            borrowRecord.setReader(reader);
            borrowRecord.setBorrowDate(new Date());
            borrowRecord.setBorrowBook(curBook);
            curBook.setBookStatus("出借中");
            System.out.println("借书成功");
            return "借书成功";
        }
    }

    @MethodService(name = "returnBook",auth = "cyh",description = "还书")
    public String returnBook(Reader reader,String returnBookName){
        BorrowRecord borrowRecord=(new BorrowRecord()).queryBorrowRecord(returnBookName,reader);
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
                returnRecord.setReader(reader);
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

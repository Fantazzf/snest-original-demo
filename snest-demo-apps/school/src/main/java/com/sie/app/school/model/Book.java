package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.engine.rule.Filter;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.MethodService;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.orm.ManyToOne;
import com.sie.snest.sdk.annotation.orm.Option;
import com.sie.snest.sdk.annotation.orm.Selection;
import com.sie.snest.sdk.annotation.validate.Validate;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Model(name = "book", description = "图书", isAutoLog = Bool.True)
public class Book extends BaseModel<Book> {

    @Property(displayName = "图书名称",displayForModel = true)
    @Validate.NotBlank
    private String bookName;

    @Property(displayName = "图书类型")
    @Selection(values = {
            @Option(label = "马邓毛列",value = "1"),
            @Option(label = "社会科学",value = "2"),
            @Option(label = "自然科学",value = "3"),
            @Option(label = "综合性图书",value = "4"),
            @Option(label = "哲学",value = "5")
    })
    private String bookType;

    @Property(displayName = "作者")
    private String author;

    @Property(displayName = "出版日期")
    private Date publishDate;

//    @Selection(values = {
//            @Option(label = "出借中", value = "2"),
//            @Option(label = "在馆", value = "1")
//    })
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

    public void setBookStatus(String bookStatus) {
        this.set("bookStatus", bookStatus);
    }

    public String getBookStatus() {
        return getStr("bookStatus");
    }

    public List<Book> search(Filter filter, List<String> properties, Integer limit, Integer offset, String order){
        @SuppressWarnings("unchecked")
        List<Map<String,Object>> result = (List<Map<String,Object>>) getMeta().get("book").callSuper(Book.class, "search", filter, properties,limit,offset,order);
        List<Book> books = result.stream().map(r -> {
            Book book = new Book();
            book.putAll(r);
            @SuppressWarnings("unchecked")
            List<BorrowRecord> borrowRecords = (List<BorrowRecord>) getMeta().get("borrow_record").callSuper(BorrowRecord.class,"search",Filter.equal("borrowBook",book.getBookName()),getAllProperties(),0,0,null);
            @SuppressWarnings("unchecked")
            List<ReturnRecord> returnRecords = (List<ReturnRecord>) getMeta().get("return_record").callSuper(ReturnRecord.class,"search",Filter.equal("returnBook",book.getBookName()),getAllProperties(),0,0,null);

            if (!borrowRecords.isEmpty()&&returnRecords.isEmpty()) {
                book.setBookStatus("出借中");
            } else {
                book.setBookStatus("在馆");
            }
            System.out.println(book.getBookStatus());
            return book;
        }).collect(Collectors.toList());
        return books;
    }

//    @MethodService(name = "queryInLibrary",description = "查询书籍",auth = "queryInLibrary")
//    public Book queryInLibrary(String bookName){
//        List<Book> books=search(Filter.equal("bookName",bookName),getAllProperties(),1,0,null);
//        if(CollectionUtils.isEmpty(books)){
//            return null;
//        }else{
//            return books.get(0);
//        }
//    }
//
//    @MethodService(name = "borrowBook",auth = "borrowBook",description = "借书")
//    public void borrowBook(String bookName){
//        Book curBook=queryInLibrary(bookName);
//        if(curBook!=null){
//            if(Objects.equals(curBook.getBookStatus(),"在馆")){
//                curBook.setBookStatus("出借中");
//                System.out.println(curBook.getBookStatus());
//            }else{
//                System.out.println("书籍已被借走！");
//
//            }
//        }else{
//            System.out.println("图书馆尚未典藏该书籍！");
//        }
//    }

//    @MethodService(name = "returnBook",auth = "returnBook",description = "还书")
//    public void ReturnBook(Date returnDate,Date borrowDate,String bookName) {
//        Book returnBook=queryInLibrary(bookName);
//        if(returnDate.compareTo(borrowDate)>0){
//            returnBook.setBookStatus("在馆");
//            System.out.println(returnBook.getBookStatus());
//        }else{
//            System.out.println("归还记录不能早于借出的日期");
//        }
//    }

}

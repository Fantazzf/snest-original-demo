package com.sie.app.school.model;

import com.sie.snest.engine.api.jsonrpc.JsonRpcServiceResponse;
import com.sie.snest.engine.model.Bool;
import com.sie.snest.engine.rule.Filter;
import com.sie.snest.engine.utils.Check;
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

    public List<ReturnRecord> search(Filter filter, List<String> properties, Integer limit, Integer offset, String order){
        List<Map<String,Object>> result = (List<Map<String,Object>>) getMeta().get("return_record").callSuper(ReturnRecord.class, "search", filter, properties,limit,offset,order);
        List<ReturnRecord> returnRecords = result.stream().map(r -> {
            ReturnRecord returnRecord=new ReturnRecord();
            returnRecord.putAll(r);
            @SuppressWarnings("unchecked")
            List<BorrowRecord> borrowRecords = (List<BorrowRecord>) getMeta().get("borrow_record").callSuper(BorrowRecord.class,"search",Filter.AND(Filter.equal("borrowBook",returnRecord.getReturnBook()),Filter.less("borrowDate",returnRecord.getReturnDate())),getAllProperties(),0,0,null);
            if (returnRecord!=null&&borrowRecords.isEmpty()) {
                throw new IllegalArgumentException("归还记录不能早于借出的日期！");
            }
            return returnRecord;
        }).collect(Collectors.toList());
        return returnRecords;
    }
//    public JsonRpcServiceResponse CheckDate(){
//        if(this.returnDate.compareTo(this.borrowRecord.getBorrowDate())<0){
//            return JsonRpcServiceResponse.message("归还记录不能早于借出的日期！");
//        }else{
//            return null;
//        }
//    }
}

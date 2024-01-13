package com.sie.app.school.model;

import com.sie.snest.engine.model.Bool;
import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.Dict;
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
    @Dict(typeCode = "bookType")
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
}

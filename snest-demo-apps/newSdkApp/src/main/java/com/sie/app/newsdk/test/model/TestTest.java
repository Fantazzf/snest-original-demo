package com.sie.app.newsdk.test.model;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.validate.Validate;

import java.util.Date;

@Model
public class TestTest extends BaseModel {

    @Property(columnName = "a", displayName = "整型int")
    @Validate.Max(value = 1000)
    private int a;

    @Property(columnName = "b", displayName = "长整型long")
    private Long b;

    @Property(columnName = "c", displayName = "浮点型")
    private Double c;

    @Property(columnName = "d", displayName = "日期")
    private Date d;

    @Property(columnName = "e", displayName = "英文字母")
    @Validate.Pattern(regexp = "[a-zA-Z]+")
    @Validate.NotBlank
    private String e;

    @Property(columnName = "f", displayName = "双精度")
    private Float f;

    @Property(columnName = "g", displayName = "整形Integer")
    private Integer g;
}

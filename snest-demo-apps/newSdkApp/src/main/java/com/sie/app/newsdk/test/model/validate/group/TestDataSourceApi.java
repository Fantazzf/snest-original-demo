package com.sie.app.newsdk.test.model.validate.group;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.validate.Validate;

@Model(name = "TestDataSource", parent = "TestDataSource")
public class TestDataSourceApi extends BaseModel<TestDataSourceApi> {
    @Property(columnName = "header", displayName = "请求头")
    @Validate.NotBlank(groups = TestDataSource.Api.class)
    private String header;

    @Validate.NotBlank(groups = TestDataSource.Api.class)
    @Property(columnName = "parameters", displayName = "请求参数")
    private String parameters;
}

package com.sie.app.newsdk.test.model.datasource;

import com.sie.snest.sdk.BaseModel;
import com.sie.snest.sdk.annotation.meta.Model;
import com.sie.snest.sdk.annotation.meta.Property;
import com.sie.snest.sdk.annotation.validate.Validate;

@Model(name = "TestDataSource", parent = "TestDataSource")
public class TestDataSourceIiot extends BaseModel {
    @Property(columnName = "uri", displayName = "URI")
    @Validate.NotBlank(groups = TestDataSource.Iiot.class)
    private String uri;
}
